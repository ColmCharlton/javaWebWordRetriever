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
                archiveArtifacts 'target/*.?ar'
            }
        }

        stage('Publish html') {
            steps {
                publishHTML([allowMissing: false,
                             alwaysLinkToLastBuild: false,
                             keepAll: true,
                             reportDir: 'C:\\Users\\ccharlton\\.jenkins\\workspace\\javaNounExtractor\\SavedFiles',
                             reportFiles: 'nouns.html',
                             reportName: 'Noun Report',
                             reportTitles: ''])
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
            to: "wesmdemos@gmail.com",
            subject: "${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
            body: """<p>${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
        <p>Check console output at <a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a></p>""",
    )

}
