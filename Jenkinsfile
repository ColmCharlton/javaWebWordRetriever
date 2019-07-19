pipeline {

    agent any
tools {

        maven ‘mvn’

    }
stages {
stage 'Access repository'
node {
	
	checkout scm
	}
	
stage 'Run Maven'
node{
	
	sh 'mvn --veresion'
	
	}
	}
}