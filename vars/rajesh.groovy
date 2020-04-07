    def call(body) {
   
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

   
}
