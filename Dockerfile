FROM maven:3.9.6-amazoncorretto-17 AS build
COPY . .
RUN maven clean package -DskipTests

FROM amazoncorretto:17-alpine3.19-jdk
RUN mkdir /app
COPY --from=build /target/gym-service-api-0.0.1-SNAPSHOT.jar /app/gym-service-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app/gym-service-api.jar"]