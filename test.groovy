pipeline {
    agent any
    
    triggers { pollSCM('* * * * *') }

    environment {
        WORK_FOLDER = 'C:\\TEST_JENKINS\\'
        GIT_FOLDER  = 'C:\\Program Files\\Git\\bin'
        MY_FILE = fileExists 'C:\\TEST_JENKINS\\README.md'
    }
    
    stages {
        stage('Begin') {
            steps {
                echo 'Starting job...'
            }
        }
        stage('Pull project') {
            when { expression { MY_FILE == 'true'} }
            steps {
                echo "Pull git project into local directory: ${GIT_FOLDER}"
                bat "cd ${MY_FILE} && git pull ${WORK_FOLDER}"
            }
        }
        stage('Clone project') {
            when { expression { MY_FILE == 'false' } }
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