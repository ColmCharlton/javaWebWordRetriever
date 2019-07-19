pipeline {

    agent any

    tools {

        maven ‘mvn’

    }

    stages {
	stage 'Access repository'
	node {
	
	checkout scm
	}
        stage('Example') {

            steps {

                sh 'mvn --version'

            }

        }

    }

}

 