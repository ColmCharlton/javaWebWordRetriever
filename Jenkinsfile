pipeline {

    agent any

    tools {

        maven ‘mvn’

    }

    stages {
	
	stage 'Access repository'{
	step {
	
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

 