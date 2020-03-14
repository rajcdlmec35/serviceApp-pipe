package main.com.serviceapp.build

def createMavenBuild(POM_PATH, MAVEN_VERSION, MVN_GOALS){
    try {
        sh "'${MAVEN_VERSION}'/bin/mvn -f '${POM_PATH}' ${MVN_GOALS}"
        print "[INFO]: Successfully Executing the Build..."

	}
    catch (error) {
        print "[ERROR]: Build is failed.. please check the console logs"
        throw error
   }
}
