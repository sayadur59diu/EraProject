# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build & Run Commands

### Backend (Maven multi-module)

```bash
# Build all modules from the root
mvn clean package -DskipTests

# Build a single service
mvn clean package -DskipTests -pl services/customer-service

# Run a single service locally (after building)
java -jar services/customer-service/target/customer-service-*.jar

# Run all tests
mvn test

# Run tests for a single service
mvn test -pl services/customer-service

# Run a single test class
mvn test -pl services/customer-service -Dtest=CustomerServiceTest
```

### Docker (full stack)

```bash
# Build JARs first, then start all services
mvn clean package -DskipTests
docker-compose up --build

# Start only infrastructure services
docker-compose up oracle-db service-registry config-server

# Rebuild and restart a single service
docker-compose up --build customer-service
```

### Frontend (React)

```bash
cd ui/nano-banking-ui
npm install
npm start        # dev server on port 3000
npm test         # Jest + React Testing Library
npm run build    # production build
```

## Architecture

Spring Boot 3.4.7 / Java 21 microservices with Oracle XE as the database.

### Service Map

| Service | Port | Role |
|---|---|---|
| service-registry | 8761 | Eureka server — all services register here |
| config-server | 8888 | Spring Cloud Config — reads from `config-repo/` git directory |
| api-gateway | 8080 | Entry point — routes to downstream services |
| customer-service | 8081 | Customer profile CRUD, Oracle schema `customer_user` |
| account-service | 8082 | Account management, Oracle schema `account_user` |
| transaction-service | 8083 | Transaction processing, Oracle schema `txn_user` |
| notification-service | 8084 | Notifications (no DB schema yet) |
| ui/nano-banking-ui | 3000 | React frontend (React 19, React Router 7, Axios) |

### Code Pattern (all services)

Each service follows: `Controller → Service interface + Impl → JpaRepository → @Entity`

Responses are always wrapped in `ApiResponse<T>` (defined in each service):
```java
ApiResponse<T> { String message; LocalDateTime timestamp; T data; }
```

Entities use Lombok (`@Data`, `@Builder`, `@NoArgsConstructor`, `@AllArgsConstructor`). Repositories extend `JpaRepository`. CORS is globally allowed (`*`) via a `WebConfiguration` bean in each service.

### Database

Oracle XE 21 runs in Docker on port **1522** (not the standard 1521). Each service owns its own Oracle schema/user (created by `db/init_customer_service.sql`). DDL is managed manually via SQL scripts — `spring.jpa.hibernate.ddl-auto=none` everywhere.

`db/` contains the SQL initialization scripts that Docker mounts on first container start.

### Module Layout

```
pom.xml                     ← parent POM (Java 21, Spring Boot 3.4.7)
common/                     ← shared utilities (included as dependency)
config-server/              ← Spring Cloud Config Server
service-registry/           ← Eureka Server
api-gateway/                ← API Gateway (routing config in application.yml)
services/
  customer-service/
  account-service/
  transaction-service/
  notification-service/
db/                         ← Oracle DDL/init scripts
ui/nano-banking-ui/         ← React app (Create React App)
docker-compose.yml
```

### Known Gaps

- **Config server git repo:** `config-server/application.properties` points to `file:///F:/Personal/EraProject/nano-banking-service/config-repo` — this local path must exist and be a git repo for the config server to start.
- **application.properties vs Docker:** Service `application.properties` files hardcode `10.11.201.120` as the DB host. In Docker, the hostname is `oracle-db`. These need to diverge (e.g., Spring profiles or env var overrides).
- **Eureka client:** The `spring-cloud-starter-netflix-eureka-client` dependency is not yet in most service POMs — services won't auto-register with the registry until it is added.
- **API Gateway routes:** No `spring.cloud.gateway.routes` are configured yet in the gateway's properties/YAML.
- **No tests:** No JUnit/Mockito test files exist in any service currently.
- **Frontend calls services directly:** The React UI posts to `http://localhost:8081` (customer-service) directly rather than going through the API gateway.
