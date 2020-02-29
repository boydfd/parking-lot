pipeline {
    agent none
    options { skipDefaultCheckout(); timeout(time: 1, unit: 'HOURS'); }
    stages {
		stage('Test/Build') {
			agent { kubernetes { label 'gradle' }}
			steps {
				checkout scm
				container ('gradle') {
					sh './gradlew checkstyleMain'
					sh './gradlew checkstyleTest'
					sh './gradlew pmdMain'
					sh './gradlew pmdTest'
					sh './gradlew test'
					sh './gradlew build'
				}
			}
			post {
				always {
					junit 'build/test-results/**/*.xml'
					step( [ $class: 'JacocoPublisher' ] )
				}
				success {
					archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
					archiveArtifacts artifacts: 'docker/*', fingerprint: true
				}
			}
		}
    }
}