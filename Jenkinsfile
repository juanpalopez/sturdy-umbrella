pipeline {

    environment {
        registry = "juanpablolopez/devo-test"
        registryCrendential= "dockerhub"
    }

    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Maven 3.6.3"
        jdk "jdk11"
    }

    stages {

        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/juanpalopez/sturdy-umbrella.git/'

                // Run Maven on a Unix agent.
                sh "mvn clean package -Dmaven.test.failure.ignore=true clean test package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }


        }

        stage ('Building Docker image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }

        stage('Deploy Docker image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', registryCrendential){
                        dockerImage.push()
                    }
                }
            }
        }

        stage('Delete Docker image') {
            steps{
                sh "docker rmi $registry:$BUILD_NUMBER"
            }
        }


    }
}
