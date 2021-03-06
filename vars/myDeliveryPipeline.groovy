def call(body) {
    // evaluate the body block, and collect configuration into the object
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

   node {
  stage('HelloWorld') {
    echo 'Hello World'
  }

  stage('git clone') {
  echo "test"
  }
}
}
