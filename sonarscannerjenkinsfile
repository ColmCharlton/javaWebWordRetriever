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
        stage('Static code analysis, PMD ') {
            steps {
                withMaven(maven: 'mvn3.6.1') {
                    sh 'mvn jxr:jxr pmd:pmd'

                }
            }
        }
            stage('Static code analysis, SonarQube ') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    // Optionally use a Maven environment you've configured already
                    withMaven(maven: 'mvn3.6.1') {
                        sh 'mvn -Dsonar.host.url=http://localhost:9005 sonar:sonar'
//                        sh 'mvn clean package sonar:sonar'
                    }
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