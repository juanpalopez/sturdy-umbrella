# Devo App

This repository contains the source code for a Spring Boot app 
that checks the health status for Rabbit MQ. It uses Spring Boot Actuator 
and redirects the index to /actuator/health/rabbit and responds a JSON with
the status.

```json
{"status":"UP"}
```

For CI/CD pipeline it uses Jenkinsfile to build and deploy the Docker image to
the Docker Hub registry: `juanpablolopez/devo-test` using the build number and 
also to the latest tag.

