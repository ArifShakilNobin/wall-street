FROM openjdk:17-jdk-slim as build
ADD target/ecommerce-0.0.1-SNAPSHOT.jar ecommerce.jar
ENTRYPOINT ["java", "-jar", "ecommerce.jar"]
