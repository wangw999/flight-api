FROM eclipse-temurin:17-jre

WORKDIR /app

COPY target/*.jar flight-api.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "flight-api.jar"]

# docker build -t flight-api .