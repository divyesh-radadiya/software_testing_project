pipeline {
	agent any
    stages {
        stage('1. Git Pull') {
            steps {
				 git url: 'https://github.com/divyesh-radadiya/calculator-devops.git', branch: 'main',
                 credentialsId: 'git-divyesh-radadiya'
            }
        }
        stage('2. Maven Build') {
            steps {
                sh 'mvn clean install'
            }
        }
         stage('3. Maven Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('4. Docker Image') {
            steps {
                script {
                    imageName = docker.build "divyeshradadiya/caldev:latest"
                }
            }
        }
        stage('5. Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('', 'jenkins-docker') {
                        imageName.push()
                    }
                }
            }
        }
        stage('6. Ansible Deploy') {
            steps {

                ansiblePlaybook colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'ansible/inventory', playbook: 'ansible/playbook.yml'

            }
        }
    }
}