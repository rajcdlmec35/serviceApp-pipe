package main.com.serviceapp.git

def gitCheckout()
{
    try{
        checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '79d43e10-ce5b-4b14-93a0-7366ee201cbe', url: 'https://github.com/ITHelp-Stream/serviceApp.git']]]
        print "Successfully clone the Repository..Validate the logs..."
	}
	catch (error) {
        print "Failed to clone the Repository..please check the logs..."
        throw error
    }
}