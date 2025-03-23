FROM eclipse-temurin:21-jdk AS buildstage

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml .
COPY src /app/src

RUN mvn clean package -DskipTests=true

FROM eclipse-temurin:21-jdk

COPY --from=buildstage /app/target/backend_mascotas-0.0.1-SNAPSHOT.jar /app/backend_mascotas.jar

EXPOSE 8082

ENTRYPOINT [ "java", "-jar", "/app/backend_mascotas.jar" ]
