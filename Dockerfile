FROM openjdk:11-slim
COPY target/resident-0.0.1-SNAPSHOT.jar resident-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/resident-0.0.1-SNAPSHOT.jar"]