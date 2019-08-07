pipeline {
    agent { label 'master' }
    triggers{
        //re-triggers pipeline on regular intervals
        cron('H H(9-16)/2 * * 1-5')
        //re-triggers pipeline new source changes
        pollSCM('H */4 * * 1-5')
    }
    tools {
        maven 'mvn3.6.1'

    }

    stages {
        stage('Deploy docker containers for Sonarqube and database') {
            steps {
                bat label: '', script: 'docker-compose -f .\\docker-compose.yml up '
            }
        }


                stage('Repo retrieval') {
            steps {
                step([$class: 'WsCleanup'])
                checkout scm
//                    git 'https://github.com/ColmCharlton/javaWebWordRetriever'
//                    git branch: 'modify', url: 'https://github.com/ColmCharlton/javaWebWordRetriever'
            }
        }

        //NEED TO ADD STEP TO RETRIEVE JENKINS WORKING DIRECTORY
        //def project_path = ""
        //dir(project_path)


        stage('Maven build and test') {
            steps{
                sh 'mvn clean compile -fn'
                sh 'mvn test'
                sh 'mvn package'
                sh 'mvn sonar:sonar'

            }
        }




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
                archiveArtifacts allowEmptyArchive: true, artifacts: '*.txt'
            }
        }

        stage('Notify User') {
            steps {
                notify 'Ran successfully!'

            }
        }
    }
}


def notify(status) {
    emailext(
            to: "cc@gmail.com",
            subject: "${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
            body: """<p>${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
        <p>Check console output at <a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a></p>""",
    )

}

