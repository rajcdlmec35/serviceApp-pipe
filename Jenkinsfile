library('serviceapp-library')
pipeline {
    agent any

    stages {
        stage('test3') {
            steps {
                script {
                    if (env.BRANCH_NAME != 'master') {
                      String a = env.BRANCH_NAME
                    
                        echo a
                    }
                }
            }
        }
    }
}

