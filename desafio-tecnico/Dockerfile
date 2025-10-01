FROM eclipse-temurin:21

WORKDIR /desafio-tecnico

COPY pom.xml
COPY src ./src

RUN mvn clean package -DskipTests

COPY builds/libs/*.jar .

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "desafio-tecnico.jar" ]