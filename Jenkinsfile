library('serviceapp-library')
pipeline {
    agent any

    stages {
        stage('Not to deploy on master or any other branch which starts with t') {
            steps {
                script {
                    String a = env.BRANCH_NAME
                    if (a != 'master') {
                        echo a
                    }else{
                          echo 'kaam bn gya!!!!!';   
                          echo a.substring(0,1);
                    }
                }
            }
        }
    }
}
