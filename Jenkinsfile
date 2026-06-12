pipeline {
    agent any
    tools {
        jdk 'JDK21'
        maven 'M3'  
    }
    stages {
        stage('Build and Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }
}