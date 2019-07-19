pipeline {
    agent any
    tools {
        maven 'mvn3.6.1' 
    }
    stages {
	
		stage('Repo retrieval') {
            steps {
                sh 'checkout scm '
            }
        }
        stage('Example') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}