pipeline {
    agent any

    environment {
        IMAGE_NAME = 'gomgoguma/kube'
    }

    stages {
        stage('Gradle Clean') {
            steps {
                echo "Gradle clean..."
                sh './gradlew clean'
            }
        }

        stage('Gradle Build without Tests') {
            steps {
                echo "Gradle build..."
                sh './gradlew build -x test'
            }
        }

        stage('Docker Build') {
            steps {
                echo 'Building Docker image...'
                sh 'docker build -t $IMAGE_NAME .'
            }
        }
    }
}
