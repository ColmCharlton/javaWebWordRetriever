pipeline {
    agent any
    tools {
        maven 'mvn3.6.1'

    }
    stages {
        stage('SCM') {
            steps {
                git branch: 'sonarcubeEdit', url: 'https://github.com/ColmCharlton/javaWebWordRetriever'
            }
        }
        stage('build && SonarQube analysis') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    // Optionally use a Maven environment you've configured already

//                    withMaven(maven:'mvn3.6.1') {
                        sh 'mvn clean package sonar:sonar'
//                    }
                }

            }
        }
    }
}