	# Use the official OpenJDK 17 as the base image
FROM openjdk:17-jdk-slim
 
# Set the working directory in the container
WORKDIR /app
 
# Copy the Gradle wrapper files to the container
COPY gradlew .
COPY gradle gradle
 
# Copy the build configuration files to the container
COPY settings.gradle .
COPY build.gradle .
 
# Copy the source code to the container
COPY src src
 
# Run the Gradle wrapper to download and install Gradle
RUN ./gradlew --version
 
# Build the Spring Boot application
RUN ./gradlew build
 
# Expose the default Spring Boot port
EXPOSE 8080
 
# Set the default command to run the Spring Boot application
CMD ["java", "-jar", "build/libs/chatapi-0.0.1-SNAPSHOT.jar"]