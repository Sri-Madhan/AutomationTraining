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
                git branch: 'main', url: 'https://github.com/Sri-Madhan/AutomationTraining.git'
            }
        }

        stage('Build') {
            steps {
                echo "Building the application"
                withEnv(["PATH+EXTRA=/usr/local/bin", "PROFILE=${PROFILE}"]) {
                    sh 'mvn clean install -P${PROFILE}' 
                }
            }
        }

        stage('Test') {
            steps {
                echo "Running tests for profile: ${PROFILE}"
                withEnv(["PATH+EXTRA=/usr/local/bin", "PROFILE=${PROFILE}"]) {
                    sh "mvn test -P${PROFILE}"  
                }
            }
        }

        stage('Zip Test Reports') {
            steps {
                echo "Zipping the test reports..."
                sh """
                    zip -r test-reports.zip test-output/extent-reports
                """
            }
        }
    }

    post {
    success {
        emailext(
            subject: "Build Success: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
            body: "The build and tests have completed successfully.\n\nYou can check the build details here: ${env.BUILD_URL}",
            to: "srimadhan218@gmail.com",  
            attachmentsPattern: 'test-reports.zip'
        )
    }
    failure {
        emailext(
            subject: "Build Failure: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
            body: "The build has failed. Please check the logs for details.\n\nBuild URL: ${env.BUILD_URL}",
            to: "srimadhan218@gmail.com", 
            attachmentsPattern: 'test-reports.zip'
        )
    }
}
}
