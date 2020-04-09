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