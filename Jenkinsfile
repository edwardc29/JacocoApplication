pipeline {
   agent any

   triggers{
           bitbucketpr(projectPath:'https://bitbucket.org/edwardc29/',
               cron: 'H/15 * * * *',
               credentialsId: '',
               username: '',
               password: '',
               repositoryOwner: '',
               repositoryName: '',
               branchesFilter: '',
               branchesFilterBySCMIncludes: false,
               ciKey: '',
               ciName: '',
               ciSkipPhrases: '',
               checkDestinationCommit: false,
               approveIfSuccess: false,
               cancelOutdatedJobs: true,
               buildChronologically: true,
               commentTrigger: '')
       }

   stages {
      stage('Checkout') {
         steps {
            checkout scm
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