FROM eclipse-temurin:17-jre

WORKDIR /app

COPY flight_Function_api/target/*.jar flight-api.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "flight-api.jar"]

# ./mvnw clean package
# docker build -t flight-api .