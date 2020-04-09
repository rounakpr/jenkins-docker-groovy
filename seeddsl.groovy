job('DSL-Test-Job') {
    scm {
        git('git@github.com:rounakpr/jenkins-docker-groovy.git')
    }
    steps {
        maven('-e clean test')
    }
}
