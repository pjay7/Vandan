# ---- Stage 1: Build the app with Maven ----
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
# Copy Maven project files and dependencies
COPY pom.xml ./
COPY src ./src
# Build the Spring Boot app (skip tests if needed)
RUN mvn clean package -DskipTests
# ---- Stage 2: Run the Spring Boot jar ----
FROM eclipse-temurin:21-jdk
WORKDIR /app
# Copy the built jar file from the builder stage
COPY --from=builder /app/target/Vandan-0.0.1-SNAPSHOT.jar app.jar
# Set default port (you can override with server.port in application.properties)
EXPOSE 8080
# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
