pipeline {
    agent any
    tools {
        maven 'mvn3.6.1' 
    }
    stages {
        stage('Example') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}