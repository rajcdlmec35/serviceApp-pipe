#!/bin/groovy

import main.com.serviceapp.build.*
import main.com.serviceapp.tools.*
import main.com.serviceapp.git.*

def call(body)
{
   def config = [:]
   body.resolveStrategy = Closure.DELEGATE_FIRST
   body.delegate = config
   body()

   timestamps {
   def g = new git()
   def cre = new mavenBuild()
   def java = new jdk()
   def m2 = new maven()
   
   
  stage ('Install all Devops Tools'){
	try {
            wrap([$class: 'AnsiColorBuildWrapper']) {
            def VERSION = "JDK1.8"
            java.setJavaHome("${VERSION}")

          }
        }
        catch (error)
        {
          wrap([$class: 'AnsiColorBuildWrapper']) {
              echo "JAVA Initializing Failed..."
              throw error
          }
        }
		
	try {
            wrap([$class: 'AnsiColorBuildWrapper']) {
            def VERSION = "Maven3"
            m2.setMavenHome("${VERSION}")

          }
        }
        catch (error)
        {
          wrap([$class: 'AnsiColorBuildWrapper']) {
              echo "Maven Initializing Failed..."
              throw error
          }
        }
  
  }
 
  stage ('checkout Source Code from git'){
  try {
      g.gitCheckout()
      echo "[SUCCESS] Source Code successfully downloaded"
      }
      catch (Exception error)
      {
          wrap([$class: 'AnsiColorBuildWrapper']) {
          echo "[ERROR] ${error}"
          throw error
          }
      }
    }
  stage ('Building source Code'){
  try{
          def MVN_GOALS = "clean compile install"
          def POM_PATH = "${WORKSPACE}/sm-shop/pom.xml"
          cre.createMavenBuild("${POM_PATH}" ,"${MAVEN_VERSION}", "${MVN_GOALS}")
          }
          catch (Exception error){
          wrap([$class: 'AnsiColorBuildWrapper']) {
            print "[INFO]: ${error}"
            throw error
          }
        }
    }

 }
}
