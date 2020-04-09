// Jenkinsfile for pipeline

node('admin') {
    stage('checkout'){
                      checkout([$class: 'GitSCM',
                      branches: [[name: '*/master']],
                      userRemoteConfigs: [[url: 'https://github.com/rounakpr/jenkins-docker-groovy.git']]
                      ])
      }
}
