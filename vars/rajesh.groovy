    def call(body) {
   /* def repoName = config.repoName
    def testWithDocker = config.testWithDocker
    def skipUnitTests = config.skipUnitTests
    def runSonar = config.runSonar
    def emailRecipientsList = config.emailRecipients

    def gitSshCredentials = 'jenkadm-github-test'
    def cloneUrl = "git@github.worldpay.com:Worldpay/${repoName}.git"
    def nexusRegistry = "slgramidlnexs60.infoftps.com/springio" */
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()
    def buildTag = env.BUILD_NUMBER
    def branchNamePlaceholder = ''

    if(!(env.BRANCH_NAME =~ /^v([0-9]+\.[0-9]+\.[0-9]+)/)) {
        buildTag = "${env.BRANCH_NAME}-${env.BUILD_NUMBER}"
        branchNamePlaceholder = "-${env.BRANCH_NAME}"
		echo env.BRANCH_NAME
    }

   /* pipeline {
        agent { label 'Docker 18.06' }

        parameters {
            string(description: 'List of Email Report Recipients', name: 'recipients', defaultValue: emailRecipientsList)
            booleanParam(defaultValue: false, description: 'Run Checkmarx Scan?', name: 'runCheckmarx')
            string(description: 'Health Check URL', name: 'healthCheckUrl', defaultValue: "https://mds-ms-dev-demographics.nonprod.nb01.local/${repoName}${branchNamePlaceholder}/actuator/health")
        }

        tools {
            maven 'maven-3.5.2-pugrarjenkap01'
            jdk 'jdk-10.0.2'
        }

        environment {
            MAVEN_OPTS = '--add-modules java.xml.bind -Xmx1024m -XX:MaxPermSize=512m -Djdk.tls.client.protocols=TLSv1.2 -Dhttps.protocols=TLSv1.2 -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true'
            REPORT_FILE= "${WORKSPACE}/index.html"
            MDS_TEST_IMAGE_NAME="mds-microservice-test-${repoName}${branchNamePlaceholder}-image"
            MDS_TEST_CONTAINER_NAME="test-${repoName}${branchNamePlaceholder}"
            BUILD_TAG = "${buildTag}"
            BRANCH_NAME_PLACEHOLDER = "${branchNamePlaceholder}"
        }

        stages {
            stage('Create report file') {
                steps {
                    createReportFile repo: repoName, branch: env.BRANCH_NAME
                }
            }
            
        stage('Checkmarx scan'){
                when {
                    expression { params.runCheckmarx == true }
                }

                agent {
                    label "stgramidlnexs60.infoftps.com"
                }

                steps{
                 checkMarxScan()
                }
            } 

            stage('Test with docker') {
                when {
                    expression { testWithDocker == true }
                }

                steps {
                    runTestsWithDocker image: MDS_TEST_IMAGE_NAME, container: MDS_TEST_CONTAINER_NAME, reportFile: REPORT_FILE
                }
            }

            stage ('Publish unit test results') {
                steps {
                    publishJUnitTestResults reportFile: REPORT_FILE
                }
            }

            stage('Build src') {
                steps {
                    runMavenBuild sonar: runSonar, skipTests: skipUnitTests, reportFile: REPORT_FILE
                }
            }

            stage('Build image') {
                steps {
                    buildDockerImage repo: repoName, registry: nexusRegistry, tag: buildTag, reportFile: REPORT_FILE
                }
            }

            stage('Push image and update k8s resources yaml') {
                steps {
                    pushDockerImage repo: repoName, registry: nexusRegistry, tag: buildTag, reportFile: REPORT_FILE
                    resolveVariablesInFile filePath: 'resources.yaml', reportFile: REPORT_FILE
                    resolveVariablesInFile filePath: 'deployit-manifest.xml', reportFile: REPORT_FILE
                }
            }

            stage('Publish to XL Deploy') {
                steps {
                    deployToXLD repo: repoName, tag: buildTag, reportFile: REPORT_FILE
                }
            }

            stage('Deploy to Kubernetes') {
                steps {
                    deployToKubernetesViaXLD environmentId: 'MDS/MDS_POC_AWS', packageId: "MDS_POC/${repoName}${branchNamePlaceholder}/${env.BUILD_NUMBER}"
                }
            }

            stage('Health Check') {
                steps {
                    springHealthCheck url: params.healthCheckUrl, reportFile: REPORT_FILE
                }
            }*/

            /*stage('Qualys Security Scan') {
                steps {
                    qualysSecurityScan repo: repoName, tag: buildTag
                }
            }*/
        /*}

        post {
            always {
                sendEmailNotification repo: repoName, branch: env.BRANCH_NAME, recipients: params.recipients, reportFile: REPORT_FILE
                deleteDir() 
            }
        }
    }*/
}
