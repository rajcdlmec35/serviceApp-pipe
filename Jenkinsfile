library('serviceapp-library')
pipeline {
    agent any

    stages {
        stage('Not to deploy on master or any other branch which starts with t') {
            steps {
                script {
                    
                    if(!env.BRANCH_NAME =~ /^v(\d{1,3})\.(\d{1,3})\.\d{1,4}$/) {
        buildTag = "${env.BRANCH_NAME}-${env.BUILD_NUMBER}"
        branchNamePlaceholder = "-${env.BRANCH_NAME}"
	    echo "test"
		    }else { echo "testing"}
                }
            }
        }
    }
}
