node {
    checkout scm
    /*
     * In order to communicate with the MySQL server, this Pipeline explicitly
     * maps the port (`3306`) to a known port on the host machine.
     */
     docker.image('centos:7').inside("--link ${c.id}:db") {
                /*
                 * Run some tests which require MySQL, and assume that it is
                 * available on the host name `db`
                 */
                sh 'make check'
            }
}