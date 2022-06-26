pipeline {
    agent any
    
    triggers { pollSCM('* * * * *') }

    environment {
        WORK_FOLDER = 'C:\\TEST_JENKINS\\'
        GIT_FOLDER  = 'C:\\Program Files\\Git\\bin'
    }
    
    stages {
        stage('Begin') {
            steps {
                echo 'Starting job...'
            }
        }
        stage('Clone project') {
            steps {
                echo "Clone git project into local directory: ${GIT_FOLDER}"
                bat "cd ${GIT_FOLDER} && git clone https://github.com/Grigory98/tests-course.git ${WORK_FOLDER}"
            }
        }
        stage('End')
        {
            steps {
                echo 'Job finished'
            }
        }
    }
}