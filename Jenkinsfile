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
        stage('Maven build and test') {
            steps {
                sh 'mvn clean verify'
            }
        }
}
}