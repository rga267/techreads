pipeline {
    agent any

    stages {
        stage('Build'){
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test'){
            steps{
                sh 'mvn surefire:test'
            }
        }
        stage('Deploy'){
            steps{
                echo 'mvn jar:jar deploy:deploy'
            }
        }
    }

    tools{
        maven 'Maven 3.8.3'

    }
}