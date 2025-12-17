<<<<<<< HEAD
# Step 1: Build stage
=======
>>>>>>> 6ffea4cd8616644413c0f021bffd33b4e40cc472
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

<<<<<<< HEAD
# Step 2: Run stage
=======
>>>>>>> 6ffea4cd8616644413c0f021bffd33b4e40cc472
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
<<<<<<< HEAD
ENTRYPOINT ["java", "-jar", "app.jar"]
=======
ENTRYPOINT ["java","-jar","app.jar"]
>>>>>>> 6ffea4cd8616644413c0f021bffd33b4e40cc472
