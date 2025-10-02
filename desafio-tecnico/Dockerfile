FROM eclipse-temurin:21-jdk AS builder

WORKDIR /desafio-tecnico

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN ./mvnw dependency:go-offline

COPY src ./src

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jre

WORKDIR /desafio-tecnico

COPY --from=builder /desafio-tecnico/target/*.jar desafio-tecnico.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "desafio-tecnico.jar"]