FROM openjdk:17-jdk-slim as build
WORKDIR /app
ADD target/ecommerce-0.0.1-SNAPSHOT.jar ecommerce.jar
ENTRYPOINT ["java", "-jar", "/app/ecommerce.jar"]
