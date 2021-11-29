pipeline {
    agent any

    stages {
        stage('Build'){
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean install'
            }
        }
        stage('Test'){
            steps{
                sh './mvnw surefire:test'
            }
        }
        stage('Deploy'){
            steps{
                echo './mvnw jar:jar deploy:deploy'
            }
        }
    }
}