pipeline {
    agent any  

    parameters {
        choice(name: 'TEST_PROFILE', choices: ['Smoke', 'Regression'], description: 'Choose the test profile to run')
    }

    environment {
        PROFILE = "${params.TEST_PROFILE}"
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Checking out code from the repository"
                git 'https://github.com/Sri-Madhan/AutomationTraining.git'
            }
        }

        stage('Build') {
            steps {
                echo "Building the application"
                sh 'mvn clean install -P${PROFILE}' 
            }
        }

        stage('Test') {
            steps {
                echo "Running tests for profile: ${PROFILE}"
                sh "mvn test -P${PROFILE}"  
            }
        }

        // stage('Deploy') {
        //     steps {
        //         echo "Deploying application"
        //         sh './deploy.sh'  // Custom deploy script
        //     }
        // }
    }

    post {
        success {
            echo "Build successful!"
        }
        failure {
            echo "Build failed."
        }
    }
}
