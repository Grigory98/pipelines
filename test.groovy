pipeline {
    agent any
    
    triggers { pollSCM('* * * * *') }

    environment {
        WORK_FOLDER = 'C:\\TEST_JENKINS\\'
        GIT = 'C:\\Program Files\\Git\\bin'
    }
    
    stages {
        stage('Begin') {
            steps {
                echo 'Begin job, test 2'
            }
        }
        stage('Clone project') {
            steps {
                bat "cd ${GIT}"
                bat "git clone https://github.com/Grigory98/tests-course.git ${WORK_FOLDER}"
            }
        }
        stage('End')
        {
            steps {
                echo 'End job'
            }
        }
    }
}