pipeline {

    agent none

    options {
    
        disableConcurrentBuilds(abortPrevious: true)
        
        buildDiscarder(logRotator(numToKeepStr: '1'))
    }
     
    stages {
                                     
        stage('cleanup docker system') {
            
            agent {
            
                label "the-god-server"
            
            }

            steps {

                dir('.build-automation/docker-image-management') {

                    sh 'bash ./cleanup-local-docker-system.bash'
                    
                }                

            }

        }   

        stage('cascade template content') {

            agent {
            
                label "the-god-server"
            
            }

            steps {

                dir('dashboard/.cascade-template-designs') {

                    sh 'bash ./cascade-template-design.bash'

                }                

            }

        }   

        stage('build docker image') {

            agent {
            
                label "the-god-server"
            
            }
            
            steps {

                dir('.build-automation/docker-image-management') {

                    sh 'bash ./build-docker-image-from-source.bash'

                }                

            }

        }      
        
        stage('push to dockerhub') {

            agent {
            
                label "the-god-server"
            
            }
            
            steps {

                dir('.build-automation/docker-image-management') {

                    sh 'bash ./push-docker-image-to-dockerhub.bash'

                }                

            }

        }


        stage('deploy container') {

            agent {
            
                label "rhea"
            
            }
            
            steps {

                dir('.build-automation/local-execution-management') {

                    sh 'bash ./deploy-latest-docker-image-localhost.bash'

                }                

            }

        }

        stage('monitor deployments') {

            agent {
            
                label "rhea"
            
            }
            
            steps {

                dir('.build-automation/local-execution-management') {

                    sh 'bash ./display-container-usage.bash'

                }                

            }

        }
        
        stage('cleanup docker // rhea') {

            agent {
            
                label "rhea"
            
            }
            
            steps {

            agent {
            
                label "placeholder"
            
            }
                dir('.build-automation/docker-image-management') {

                    sh 'bash ./cleanup-local-docker-system.bash'

                }                 

            }

        }
        
        stage('cleanup docker // placeholder') {

            agent {
            
                label "the-god-server"
            
            }
            
            steps {

            agent {
            
                label "placeholder"
            
            }
                dir('.build-automation/docker-image-management') {

                    sh 'bash ./cleanup-local-docker-system.bash'

                }                 

            }

        }
        
}}
