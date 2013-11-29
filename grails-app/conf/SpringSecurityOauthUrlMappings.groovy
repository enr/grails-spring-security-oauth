import grails.plugin.springsecurity.SpringSecurityUtils
import org.scribe.exceptions.OAuthException

class SpringSecurityOauthUrlMappings {

    static mappings = {
    	if (SpringSecurityUtils.securityConfig.oauth.active) {
        	"/oauth/$provider/success"(controller: "springSecurityOAuth", action: "onSuccess")
        	"/oauth/$provider/failure"(controller: "springSecurityOAuth", action: "onFailure")
        	"/oauth/askToLinkOrCreateAccount"(controller: "springSecurityOAuth", action: "askToLinkOrCreateAccount")
        	"/oauth/linkaccount"(controller: "springSecurityOAuth", action: "linkAccount")
        	"/oauth/createaccount"(controller: "springSecurityOAuth", action: "createAccount")

        	"500"(controller: "login", action: "auth", exception: OAuthException)
    	}
    }

}
