FROM openjdk:11
EXPOSE 8080

# Refer to Maven build -> finalName
ARG JAR_FILE=target/devo-test-1.0.0.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]