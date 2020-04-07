library('serviceapp-library')
pipeline {
    agent any

    stages {
        stage('Not to deploy on master or any other branch which starts with t') {
            steps {
                script {
                    
                    if(!(env.BRANCH_NAME =~ /^v([0-9]+\.[0-9]+\.[0-9]+)/) || (env.BRANCH_NAME =~ /^v+\.([0-9]+\.[0-9]+\.[0-9]+\.[A-Z]+)/)) {
        buildTag = "${env.BRANCH_NAME}-${env.BUILD_NUMBER}"
        branchNamePlaceholder = "-${env.BRANCH_NAME}"
	    echo "test"
		    }else { echo "tested"}
                }
            }
        }
    }
}
