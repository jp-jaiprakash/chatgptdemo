#!/bin/bash -l

pipeline {
    agent any

    environment {
        DOCKER_IMAGE_NAME = 'my-app'
        DOCKER_IMAGE_TAG = 'latest'
        MAVEN_HOME = '/Users/jaiprakash/Downloads/apache-maven-3.9.0'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Clean') {
            steps {
            sh "${MAVEN_HOME}/bin/mvn clean"
            }
        }

        stage('Compile') {
            steps {
                sh 'mvn compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG} ."
            }
        }

        stage('Publish Docker Image') {
            steps {
                sh "docker run -d -p 9000:8080 --name my-app-container ${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}"
            }
        }
    }
}
