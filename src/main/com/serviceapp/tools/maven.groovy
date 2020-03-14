package main.com.serviceapp.tools

def setMavenHome(VERSION){
    try{
       env.MAVEN_VERSION="${tool "${VERSION}"}"
       env.PATH="${env.MAVEN_VERSION}/bin:${env.PATH}"
       sh '${MAVEN_VERSION}/bin/mvn --version'
    }
    catch (error){
      print "Failed to set the MAVEN_VERSION"
      throw error
    }
}