def call(Map config = [:]) {
    def cloneUrl = "git@github.com:rajcdlmec35/helloworld.git"
    def buildTag = env.BUILD_NUMBER
    def branchNamePlaceholder = ''
    
	string a = env.BRANCH_NAME   
    if(env.BRANCH_NAME != 'master' || a.substring(0,1)!="v") {
        buildTag = "${env.BRANCH_NAME}-${env.BUILD_NUMBER}"
        branchNamePlaceholder = "-${env.BRANCH_NAME}"
    }

    pipeline {
        agent any

        environment {
            
            BRANCH_NAME_PLACEHOLDER = "${branchNamePlaceholder}"
        }

        stages {
            stage('Create report file') {
                steps {
                    createReportFile repo: repoName, branch: env.BRANCH_NAME
                }
            }
            
    
        }
  }
