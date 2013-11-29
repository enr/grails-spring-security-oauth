import grails.plugin.springsecurity.SpringSecurityUtils

/**
* @author <a href='mailto:cazacugmihai@gmail.com'>Mihai Cazacu</a>
* @author <a href='mailto:enrico@comiti.name'>Enrico Comiti</a>
* @author <a href='mailto:donbeave@gmail.com'>Alexey Zhokhov</a>
*/
class SpringSecurityOauthGrailsPlugin {
    def version = "2.0.2"
    def grailsVersion = "2.0 > *"
    def dependsOn = [springSecurityCore: '2.0-RC2 > *', oauth: "2.3"]
    def pluginExcludes = [
            "web-app/css",
            "web-app/images",
            "web-app/js/prototype",
            "web-app/js/application.js"
    ]

    def title = "Spring Security OAuth plugin"
    def author = "Mihai Cazacu, Enrico Comiti, Alexey Zhokhov"
    def authorEmail = "cazacugmihai@gmail.com"
    def description = '''Adds OAuth-based authentication to the
[Spring Security plugin|http://grails.org/plugin/spring-security-core] using the
[OAuth plugin|http://grails.org/plugin/oauth-scribe]. This plugin provides an OAuth realm that can easily be integrated
into existing applications and a host of utility functions to make things like "log in with Twitter" almost trivial.'''

    def documentation = "http://grails.org/plugin/spring-security-oauth"

    def license = "APACHE"
    def organization = [name: "Macrobit Software", url: "http://macrobit.ro/"]
    def developers = [
        [name: "Mihai Cazacu", email: "cazacugmihai@gmail.com"],
        [name: "Enrico Comiti", email: "enrico@comiti.name"],
        [name: "Alexey Zhokhov", email: "donbeave@gmail.com"]]
    def issueManagement = [system: "JIRA", url: "http://jira.grails.org/browse/GPSPRINGSECURITYOAUTH"]
    def scm = [url: 'https://github.com/grails-plugins/grails-spring-security-oauth/']

    def doWithSpring = {
        def conf = SpringSecurityUtils.securityConfig

        boolean printStatusMessages = (conf.printStatusMessages instanceof Boolean) ? conf.printStatusMessages : true

        if (!conf || !conf.active) {
            return
        }

        SpringSecurityUtils.loadSecondaryConfig 'DefaultSpringSecurityOAuthConfig'
        // have to get again after overlaying DefaultSpringSecurityOAuthConfig
        conf = SpringSecurityUtils.securityConfig

        if (!conf.oauth.active) {
            return
        }

        if (printStatusMessages) {
            println '\nConfiguring Spring Security OAuth ...'

            println '... finished configuring Spring Security OAuth\n'
        }
    }

}
