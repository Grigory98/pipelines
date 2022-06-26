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
                echo 'Begin job, test 4'
            }
        }
        stage('Clone project') {
            steps {
                bat "cd ${GIT_FOLDER} && git clone https://github.com/Grigory98/tests-course.git ${WORK_FOLDER}"
                //bat "git clone https://github.com/Grigory98/tests-course.git ${WORK_FOLDER}"
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