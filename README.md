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

## To run the app

Since the docker image is already uploaded to docker hub (juanpablolopez/depo-test:latest). You can use the helm repo to deploy both rabbitmq and the app on a Kubernetes Cluster o locally using Minikube: https://github.com/juanpalopez/improved-octo-guide 

Though if you need to run the app locally without k8s make sure to have a rabbitmq service running. Also change the application-local.properties to match your rabbitmq host and port.

Locally without k8s:

```bash
$> export SPRING_PROFILES_ACTIVE=local

$> mvn spring-boot:run
# or
$> mvn clean package
$> java -jar ./target/devo-test-1.0.0.jar
```

