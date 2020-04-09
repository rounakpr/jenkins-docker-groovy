// Jenkinsfile for pipeline

node('admin') {
    stage('checkout'){
                      checkout([$class: 'GitSCM',
                      branches: [[name: '*/master']],
                      userRemoteConfigs: [[url: 'https://github.com/rounakpr/jenkins-docker-groovy.git']]
                      ])
    }
    stage('Clone repository') {
          // This is another way to clone repository
          checkout scm
    }
    stage('Build Docker Image') {
          // This builds the image similar to commandline
          def customImage = docker.build("myjenkins:${env.BUILD_ID}")
    }
}
