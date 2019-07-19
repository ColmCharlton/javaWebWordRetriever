pipeline {

    agent any
tools {

        maven ‘mvn’

    }

stage 'Access repository'
node {
	
	checkout scm
	}
	
stage 'Run Maven'
node{
	
	sh 'mvn --veresion'
	
	}
}