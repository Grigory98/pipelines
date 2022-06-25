pipeline {
    agent any
    
    environment {
        WORK_FOLDER = 'C:\\TEST_JENKINS\\'
    }
    
    stages {
        stage('Begin') {
            steps {
                echo 'Begin job, test 2'
            }
        }
        stage('Ping') {
            steps {
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