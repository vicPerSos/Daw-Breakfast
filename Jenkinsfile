pipeline{
    agent any
    stages{
        stage('Build'){
            steps{
                echo 'Building the project...'
            }
        }
        stage('Test'){
            steps{
                echo 'Testing the project...'
            }
        }
        stage('Deploy'){
            steps{
                sh "docker-compose down -v"
                sh "docker-compose up -d --build"
            }
        }
    }
}