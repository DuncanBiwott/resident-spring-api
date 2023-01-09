FROM openjdk:11
EXPOSE 9192
ADD target/resident-0.0.1-SNAPSHOT.jar resident-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","resident-0.0.1-SNAPSHOT.jar"]