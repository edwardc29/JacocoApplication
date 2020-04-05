pipeline {
   agent any

   stages {
      stage('Checkout') {
         steps {
            checkout scm
         }
      }
      stage('Sonar') {
         withSonarQubeEnv("SonarQube") {
            sh "./gradlew --info sonarqube --no-daemon"
         }
      }
   }
}