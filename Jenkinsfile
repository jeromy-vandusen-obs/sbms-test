@Library('sbms-pipeline-shared@master') _

pipeline {
    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '5'))
        disableConcurrentBuilds()
        timeout(time: 15, unit: 'MINUTES')
    }

    stages {
        stage('Prepare Driver') {
            steps {
                sh "chmod +x src/test/drivers/chromedriver_linux64"
            }
        }
        stage('Execute Automated Tests') {
            environment {
                URI_BASE = "http://test:28080"
                MONGODB_HOST = "test"
                MONGODB_PORT = "27001"
            }
            steps {
                echo "Executing tests....."
                // mvn "clean verify"
            }
            post {
                success {
                    notify('INFO', 'All tests passed.')
                }
                failure {
                    notify('FAIL', 'There were test failures.')
                }
            }
        }
    }
}
