pipeline {
    agent any
    tools {
        maven 'mvn3.6.1' 
    }
    stages {
	
		stage('Repo retrieval') {
            steps {
                checkout scm
            }
        }
        stage('Maven') {
            steps {
                sh 'mvn instal'
            }
        }
    }
}