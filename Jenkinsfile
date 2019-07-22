pipeline {
    agent any
    tools {
        maven 'mvn3.6.1'
    }
    stages {
        try {
            stage('Repo retrieval') {
                steps {
                    checkout scm
//                    git 'https://github.com/ColmCharlton/javaWebWordRetriever'
//                    git branch: 'modify', url: 'https://github.com/ColmCharlton/javaWebWordRetriever'
                }
            }

            stage('Maven build and test') {
                steps {
                    sh 'mvn clean verify'
                }
            }

            //def project_path = ""
            //dir(project_path)


            stage('Archival') {
                steps {
                    publishHTML([allowMissing         : true,
                                 alwaysLinkToLastBuild: false,
                                 keepAll              : true,
                                 reportDir            : 'target\\site\\jacoco',
                                 reportFiles          : 'index.html',
                                 reportName           : 'Code Coverage',
                                 reportTitles         : ''])

                    step([$class     : 'JUnitResultArchiver',
                          testResults: 'target/surefire-reports/TEST-*.xml'])

                    archiveArtifacts 'target/*.?ar'
                }
            }


            // limit concurrency so we don't perform simultaneous deploys
            // and if multiple pipelines are executing,
            // newest is only that will be allowed through, rest will be canceled


            stage('Deploy to docker') {
                steps {
                    // deploy to a docker container mapped to port 80
                    // on windows use: bat 'docker-compose up -d --build'
                    // bat 'docker-compose up -d --build'

                    notify 'Deployed!'
                }

            }
        } catch (err) {
            notify("Error ${err}")
            currentBuild.result = 'Failure'
        }
    }
}
def notify(status) {
    emailext(
            to: "wesmdemos@gmail.com",
            subject: "${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
            body: """<p>${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
        <p>Check console output at <a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a></p>""",
    )

}
