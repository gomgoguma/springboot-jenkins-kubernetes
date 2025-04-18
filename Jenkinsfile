pipeline {
    agent any

    environment {
        IMAGE_NAME = 'gomgoguma/kube'
        IMAGE_TAG = 'v0.0.1'
        CREDENTIALS_ID = 'docker-token'
        REGISTRY = 'https://registry-1.docker.io'
        GITHUB_TOKEN_ID = credentials('github-token')
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
                script {
                    docker.build("${IMAGE_NAME}:${IMAGE_TAG}")
                }
            }
        }

        stage('Docker Push') {
            steps {
                echo 'Push Docker image...'
                script {
                    docker.withRegistry("${REGISTRY}", "${CREDENTIALS_ID}") {
                        docker.image("${IMAGE_NAME}:${IMAGE_TAG}").push()
                    }
                }
            }
        }

        stage('SSH to Remote Server and Deploy Commands') {
            steps {
                script {
                    sshagent(['ssh-key-for-deploy']) {
                        sh '''
                            ssh -o StrictHostKeyChecking=no gomgoguma@gomgoguma.iptime.org "
                                cd ~/k3s/spring
                                curl -H 'Authorization: token ${GITHUB_TOKEN}' https://... -o deploy.yaml
                                sudo kubectl apply -f deploy.yaml
                            "
                        '''
                    }
                }
            }
        }
    }
}
