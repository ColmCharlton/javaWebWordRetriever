stage 'Access repository'
node {
	
	checkout scm
	}
	
stage 'Run Maven'
node{
	
	sh 'mvn --version'
	
	stage 'Notify user'
	node{
	notify 'Ran!'
	}
}
