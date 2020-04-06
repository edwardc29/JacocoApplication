pipeline {
   agent any

   stages {
      stage('Checkout') {
         steps {
            checkout scm
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