# Spring Boot Review Skill

Review the specified service (or all services) against the best practices for this project.
If no target is given, review every service under `services/`.

## How to run

1. Read the target service's Java sources, `pom.xml`, and `application.properties`.
2. Check each category below in order.
3. Report findings grouped by category with file + line references.
4. Distinguish **must-fix** (correctness / security) from **should-fix** (quality) from **nice-to-have** (polish).

---

## Review Categories

### 1. Layer Discipline
Each service must follow: `Controller → Service interface + Impl → Repository → Entity`

- Controller must NOT contain business logic (default-setting, date assignment, status defaulting belong in the Service layer).
- Service methods must be `@Transactional` for writes; read-only methods should use `@Transactional(readOnly = true)`.
- Repository must extend `JpaRepository<Entity, ID>` only — no custom SQL unless truly necessary.

### 2. Input Validation (must-fix)
- Controllers must NOT accept `@Entity` classes directly as `@RequestBody`. Use a dedicated request DTO.
- Every `@RequestBody` must be annotated with `@Valid` (Bean Validation).
- DTOs must carry constraint annotations (`@NotBlank`, `@Email`, `@NotNull`, `@Size`, etc.).
- A `@ControllerAdvice` `GlobalExceptionHandler` must handle `MethodArgumentNotValidException` and return an `ApiResponse` with field-level error messages.

### 3. Exception Handling (must-fix)
- No `.orElse(new ResponseEntity<>(..., NOT_FOUND))` patterns in controllers — use `.orElseThrow(() -> new ResourceNotFoundException(...))` and catch in `@ControllerAdvice`.
- Define a `ResourceNotFoundException` (extends `RuntimeException`) per service or in `common/`.
- `GlobalExceptionHandler` must also handle generic `Exception` to prevent stack traces leaking to clients.

### 4. Entity Design
- Do NOT use `@Data` on `@Entity` classes — Lombok generates `equals`/`hashCode` using all fields, which breaks JPA identity and causes `LazyInitializationException` in collections. Use `@Getter @Setter @ToString(exclude = {...})` instead.
- For Oracle, prefer `GenerationType.SEQUENCE` over `IDENTITY`:
  ```java
  @SequenceGenerator(name = "customer_seq", sequenceName = "CUSTOMER_SEQ", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
  ```
- `@Lob` on Oracle `VARCHAR2`-backed columns causes CLOB mapping issues — use `@Column(columnDefinition = "CLOB")` explicitly or remove `@Lob` if the column is `VARCHAR2`.
- Primary key `@Column` mapping should include the Oracle column name explicitly.

### 5. API Response Consistency
- Every endpoint must return `ResponseEntity<ApiResponse<T>>`.
- `ApiResponse<T>` is defined per-service (`dto/ApiResponse.java`) — flag it if missing or inconsistent with the canonical shape: `{ message, timestamp, data }`.
- HTTP status codes: `201 CREATED` for POST, `200 OK` for GET/PUT/DELETE (project convention — delete returns body, not 204).
- List endpoints with potentially large results must support pagination: accept `Pageable` and return `Page<T>`.

### 6. Configuration & Profiles (must-fix)
- `application.properties` must NOT hardcode the DB host IP (`10.11.201.120`). Use `${DB_HOST:localhost}` so Docker and local environments override via env var.
- Confirm `spring.jpa.show-sql=true` is NOT set in a production profile — it is fine for development.
- Eureka client config must be present if the service should register:
  ```properties
  eureka.client.service-url.defaultZone=http://${EUREKA_HOST:localhost}:8761/eureka
  ```
- Config server integration: services should pull config from config-server when available (add `spring-cloud-starter-config` dependency and `spring.config.import=optional:configserver:`).

### 7. Dependencies (pom.xml)
- Each service must have `spring-cloud-starter-netflix-eureka-client` to register with service-registry.
- Actuator (`spring-boot-starter-actuator`) should be present for health checks used by Docker/gateway.
- `ojdbc8` version `12.2.0.1` is outdated — flag if Oracle XE 21 is the target; version `21.x` is preferred.
- No duplicate dependency declarations (e.g., Lombok scope must be `provided`).

### 8. Security
- CORS is globally open (`*`) in `WebConfiguration` — acceptable only during development. Flag if any service is intended for production exposure.
- Passwords in `application.properties` must not be committed — flag if plaintext credentials exist and recommend `${DB_PASSWORD}` env var substitution.
- No SQL injection risk from raw string concatenation in repository queries.

### 9. Logging
- Each class that performs business operations must have a `private static final Logger log = LoggerFactory.getLogger(Foo.class);` (or `@Slf4j` from Lombok).
- Sensitive fields (passwords, tokens, NID numbers) must never be logged.

### 10. Test Coverage (nice-to-have — project currently has none)
- Flag absence of tests. Minimum expected: one `@WebMvcTest` per controller and one `@DataJpaTest` per repository.
- Service unit tests should use Mockito to mock the repository.

---

## Output Format

```
## [ServiceName] Review

### Must-Fix
- [CATEGORY] description — `path/to/File.java:line`

### Should-Fix
- [CATEGORY] description — `path/to/File.java:line`

### Nice-to-Have
- [CATEGORY] description — `path/to/File.java:line`

### Summary
X must-fix | Y should-fix | Z nice-to-have
```

If no issues are found in a category, omit it from the output.
