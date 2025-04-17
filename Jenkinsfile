pipeline {
    agent any

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
    }
}
