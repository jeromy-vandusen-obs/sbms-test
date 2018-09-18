@Library('sbms-pipeline-shared@master') _

pipeline {
    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '5'))
        disableConcurrentBuilds()
        timeout(time: 15, unit: 'MINUTES')
    }

    stages {
        stage('Execute Automated Tests') {
            environment {
                URI_BASE = "http://172.24.140.88:28080"
                MONGODB_HOST = "172.24.140.88"
                MONGODB_PORT = "27001"
            }
            steps {
                sh "mvn clean verify"
            }
            post {
                always {
                    tearDown("$STACK_NAME")
                    sh "rm -rf $MONGODB_DATA_PATH/*"
                }
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
