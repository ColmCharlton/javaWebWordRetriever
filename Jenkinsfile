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
        stage('Archival') {
                    publishHTML(target: [allowMissing         : true,
                                         alwaysLinkToLastBuild: false,
                                         keepAll              : true,
                                         reportDir            : 'target/site/jacoco',
                                         reportFiles          : 'index.html',
                                         reportName           : 'Code Coverage',
                                         reportTitles         : ''])
                    archiveArtifacts allowEmptyArchive: true, artifacts: '*.txt'
                    archiveArtifacts allowEmptyArchive: true, artifacts: 'target/*.jar'
                }


        // limit concurrency so we don't perform simultaneous deploys
        // and if multiple pipelines are executing,
        // newest is only that will be allowed through, rest will be canceled

        //stage('Deploy to staging'){
            // write build number to index page so we can see this update
            // on windows use:
         //   steps {
         //   bat "echo '<h1>${env.BUILD_DISPLAY_NAME}</h1>' >> app/index.html"
         //                           }
         //   }

        stage('Deploy to docker'){
        steps {
            // deploy to a docker container mapped to port 80
            // on windows use: bat 'docker-compose up -d --build'
            bat 'docker-compose up -d --build'

            notify 'Deployed!'
            }

        }
    }
}

def notify(status){
    emailext (
      to: "wesmdemos@gmail.com",
      subject: "${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
      body: """<p>${status}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
        <p>Check console output at <a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a></p>""",
    )

}