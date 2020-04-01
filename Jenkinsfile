library('serviceapp-library')
node {
    stage 'Clone and Build'
        sh 'rm -rf /var/lib/jenkins/workspace/shared_library/*'
        sh 'git clone git@github.com:rajcdlmec35/serviceApp-pipe.git'
        sh 'cp -r /var/lib/jenkins/workspace/shared_library/serviceApp-pipe/* /var/lib/jenkins/workspace/shared_library/'
        sh 'cd /var/lib/jenkins/workspace/shared_library/'
        sh '/var/lib/jenkins/apache-maven-3.5.3/bin/mvn clean'
     }
