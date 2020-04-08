pipeline {
   agent any

   stages {
      stage('Checkout') {
         steps {
            checkout scm

            this.notifyBitbucket('INPROGRESS')
         }
      }
      stage('Build') {
        steps {
            sh "./gradlew assembleDebug --no-daemon"
        }
      }
      stage('Sonar') {
      	 steps {
      	 	withSonarQubeEnv("SonarQube") {
               sh "./gradlew --info sonarqube --no-daemon"
            }
      	 }
      }
   }
}

def notifyBitbucket(String state) {

    if('SUCCESS' == state || 'FAILED' == state) {
    // Set result of currentBuild !Important!
        currentBuild.result = state
    }

    notifyBitbucket commitSha1: ${env.GIT_COMMIT}, considerUnstableAsSuccess: true, credentialsId: ' BitbucketAppPassword', disableInprogressNotification: false, ignoreUnverifiedSSLPeer: true, includeBuildNumberInKey: false, prependParentProjectKey: false, projectKey: '', stashServerBaseUrl: 'http://repository.url/'

}