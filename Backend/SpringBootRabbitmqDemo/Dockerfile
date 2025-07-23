# Use a slim and compatible OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Optional: set working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/rabbitmqdemo-0.0.1-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
