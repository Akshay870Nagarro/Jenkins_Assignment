pipeline {

    agent any

    tools {

        maven 'MAVEN_HOME' 

    }

 

 

    stages {

        stage('Example') {

            steps {

 

                withMaven(maven: 'MAVEN_HOME') {

 

                    bat 'mvn clean test'

                }

            }

        }

    }

}
