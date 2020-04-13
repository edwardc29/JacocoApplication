pipeline {
   agent any

    options {
       buildDiscarder(logRotator(numToKeepStr: '5'))
    }

    triggers {
       pollSCM('0 10-18 * * 1-5')
    }

   stages {
      stage('Checkout') {
         steps {
            bitbucketStatusNotify(buildState: 'INPROGRESS')
            checkout scm
            echo 'checkout...'
         }
      }
      stage('Build') {
        steps {
            sh "./gradlew assembleDebug --no-daemon"
            echo 'building...'
        }
      }
      stage('Sonar') {
      	 steps {
      	 	withSonarQubeEnv("SonarQube") {
               sh "./gradlew --info sonarqube --no-daemon"
               echo 'sonar....'
            }
      	 }
      }

      stage("Quality Gate") {
         steps {
            script {
               def qg = waitForQualityGate()
                  if (qg.status != 'OK') {
                     error "Pipeline aborted due to quality gate failure: ${qg.status}"
                  }
            }
         }
      }
   }

   post {
      success {
         bitbucketStatusNotify(buildState: 'SUCCESSFUL')
         echo 'Successful!'
      }
      aborted {
         bitbucketStatusNotify(buildState: 'FAILED')
         echo 'ABORTED!'
      }
      failure {
         bitbucketStatusNotify(buildState: 'FAILED')
         echo 'FAILED!'
      }
   }
}