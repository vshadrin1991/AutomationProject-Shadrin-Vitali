pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                cleanWs()
                git branch: 'main', url:'https://github.com/vshadrin1991/AutomationProject-Shadrin-Vitali.git'
                // Run Maven on a Unix agent.
                bat 'mvn clean test -Dsuite="src/test/resources/Lecture_18.xml"'
            }
        }
    }
}
