pipeline {
    agent any
    
    triggers { pollSCM('* * * * *') }

    environment {
        WORK_FOLDER = 'C:\\TEST_JENKINS\\'
    }
    
    stages {
        stage('Begin') {
            steps {
                echo 'Begin job, test 3'
            }
        }
        stage('Clone project') {
            steps {
                bat "ping yandex.ru"
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