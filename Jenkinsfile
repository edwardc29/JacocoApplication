pipeline {
   agent any

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