def call(body) {
    // evaluate the body block, and collect configuration into the object
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

    node {
    //some var declarations... or whatever

    try {
        //do some stuff, run your tests, etc.            
    } finally {
        junit 'build/test-results/test/*.xml'
    }
}
}
