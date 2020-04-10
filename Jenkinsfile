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
            echo 'checkout...'
         }
      }
      stage('Build') {
        steps {
            echo 'building...'
        }
      }
      stage('Sonar') {
      	 steps {
      	 	echo 'analyzing Sonar...'
      	 }
      }
   }
}