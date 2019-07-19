pipeline {

    agent any

    tools {

        maven ‘mvn’

    }

    stages {
	
	stage 'Access repository'{
	steps {
	
		checkout scm
		}
	}
    stage('Example') {
	steps {
            sh 'mvn --version'
            }

        }

    }

}

 