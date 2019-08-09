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
                    withMaven(maven: 'mvn3.6.1') {
                        sh 'mvn clean package -Dsonar.host.url=http://localhost:9005 sonar:sonar'
//                        sh 'mvn clean package sonar:sonar'
//                    }
                    }

                }
            }
        }
//        stage("Quality Gate") {
//            steps {
//                timeout(time: 1, unit: 'HOURS') {
//                    // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
//                    // true = set pipeline to UNSTABLE, false = don't
//                    waitForQualityGate abortPipeline: false
//                }
//            }
//        }
    }
}