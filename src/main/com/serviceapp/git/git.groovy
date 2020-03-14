package main.com.serviceapp.git

def gitCheckout()
{
    try{
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '2d2da1f8-e62f-4fe2-bb86-13b88b0c02e3', url: 'https://github.com/ITHelp-Stream/serviceApp.git']]])
        print "Successfully clone the Repository..Validate the logs..."
	}
	catch (error) {
        print "Failed to clone the Repository..please check the logs..."
        throw error
    }
}