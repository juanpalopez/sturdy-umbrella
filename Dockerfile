FROM openjdk:11
EXPOSE 8080
ADD target/devo-test-1.0.0.jar devo-test-1.0.0.jar
ENTRYPOINT ["java","jar","simple-maven-project-with-tests-1.0-SNAPSHOT.jar"]