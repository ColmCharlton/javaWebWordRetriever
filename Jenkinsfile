pipeline {
    agent { label 'master' }
    triggers{
        //re-triggers pipeline on regular intervals
        cron('H H(9-16)/2 * * 1-5')
        //re-triggers pipeline new source changes
        pollSCM('H */4 * * 1-5')
    }

    docker {
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/root/.m2'
                }

    stages {
        stage('Repo retrieval') {
            steps {
                step([$class: 'WsCleanup'])
                checkout scm
//                    git 'https://github.com/ColmCharlton/javaWebWordRetriever'
//                    git branch: 'modify', url: 'https://github.com/ColmCharlton/javaWebWordRetriever'
            }
        }





    }
}


