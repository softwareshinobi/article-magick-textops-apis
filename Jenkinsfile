pipeline {

    agent any

    stages {

        stage('Run Script') {
        
            steps {
                   sh 'pwd'
                   sh 'chmod +x ./build-automation/pass-01-build-docker-image-from-scratch.sh'
                   sh 'cd build-automation;./pass-01-build-docker-image-from-scratch.sh'
            }
            
        }
        
    }
    
}
