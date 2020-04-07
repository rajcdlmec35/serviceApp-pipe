library('serviceapp-library')
pipeline {
    agent any

    stages {
        stage('Not to deploy on master or any other branch which starts with t') {
            steps {
                script {
                    
                    if(env.BRANCH_NAME = ~/^v\/\d*\.\d*.\d*./) {
        buildTag = "${env.BRANCH_NAME}-${env.BUILD_NUMBER}"
        branchNamePlaceholder = "-${env.BRANCH_NAME}"
	    echo "test"
		    }else { echo "testing"}
                }
            }
        }
    }
}
