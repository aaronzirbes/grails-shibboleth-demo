// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if(System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = 'edu.umn.idm.demo' // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [ html: ['text/html','application/xhtml+xml'],
                      xml: ['text/xml', 'application/xml'],
                      text: 'text/plain',
                      js: 'text/javascript',
                      rss: 'application/rss+xml',
                      atom: 'application/atom+xml',
                      css: 'text/css',
                      csv: 'text/csv',
                      all: '*/*',
                      json: ['application/json','text/json'],
                      form: 'application/x-www-form-urlencoded',
                      multipartForm: 'multipart/form-data'
                    ]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// whether to install the java.util.logging bridge for sl4j. Disable for AppEngine!
grails.logging.jul.usebridge = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// set per-environment serverURL stem for creating absolute links
environments {
    production {
        grails.serverURL = "https://localhost/${appname}"
		// Enable shibboleth, disable mock
		grails.plugins.springsecurity.shibboleth.active = true
		grails.plugins.springsecurity.mock.active = false
    }
    development {
        grails.serverURL = "http://localhost:8080/${appName}"
		// Enable Mock security for development mode
		grails.plugins.springsecurity.shibboleth.active = false
		grails.plugins.springsecurity.mock.active = true
		grails.plugins.springsecurity.ipRestrictions = [ '/**': ['127.0.0.0/8', '::1/128'] ]
    }
    test {
        grails.serverURL = "http://localhost:8080/${appName}"
		// Enable shibboleth, disable mock
		grails.plugins.springsecurity.shibboleth.active = true
		grails.plugins.springsecurity.mock.active = false
    }
}

// log4j configuration
log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error  'org.codehaus.groovy.grails.web.servlet',  //  controllers
           'org.codehaus.groovy.grails.web.pages', //  GSP
           'org.codehaus.groovy.grails.web.sitemesh', //  layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping', // URL mapping
           'org.codehaus.groovy.grails.commons', // core / classloading
           'org.codehaus.groovy.grails.plugins', // plugins
           'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'

    warn   'org.mortbay.log'
}

//*** BEGIN MOCK SECURITY CONFIGURATION SETTING ***/
grails.plugins.springsecurity.mock.fullName = "Aaron J. Zirbes"
grails.plugins.springsecurity.mock.email = "ajz@umn.edu"
grails.plugins.springsecurity.mock.username =  "ajz"
grails.plugins.springsecurity.mock.roles = [ 'ROLE_USER', 'ROLE_ADMIN', 'ROLE_LOCALHOST_IP' ]
//*** END MOCK SECURITY CONFIGURATION SETTING ***/

//*** BEGIN SHIBBOLETH CONFIGURATION SETTINGS ***/

// Used by Controllers
grails.plugins.springsecurity.shibboleth.loginUrl = '/Shibboleth.sso/Login?target={0}'
grails.plugins.springsecurity.shibboleth.logoutUrl = '/Shibboleth.sso/Logout'

// Token Attributes
grails.plugins.springsecurity.shibboleth.principalUsername.attribute = 'EPPN'
grails.plugins.springsecurity.shibboleth.authenticationMethod.attribute = 'Shib-Authentication-Method'
grails.plugins.springsecurity.shibboleth.identityProvider.attribute = 'Shib-Identity-Provider'
grails.plugins.springsecurity.shibboleth.authenticationInstant.attribute = 'Shib-Authentication-Instant'

// Used by Authentication Provider, Exposed by IdP
grails.plugins.springsecurity.shibboleth.roles.attribute = null
grails.plugins.springsecurity.shibboleth.roles.separator = ','
grails.plugins.springsecurity.shibboleth.roles.prefix = 'SHIB_'
grails.plugins.springsecurity.shibboleth.extraAttributes = [ 'uid', 'Shib-Session-Index', 'Shib-Session-ID', 'Shib-AuthnContext-Class', 'Shib-Application-ID' ]

// This maps roles to authentication methods to allow for security annotations
// for securing based on method
grails.plugins.springsecurity.shibboleth.authenticationMethod.roles = [
    'ROLE_UMN_MKEY': 'https://www.umn.edu/shibboleth/classes/authncontext/mkey' ]
	// grails.plugins.springsecurity.shibboleth.authenticationMethod.roles = null

// Allow location based roles
grails.plugins.springsecurity.remoteaddress.roles = [
	'ROLE_LOCALHOST_IP': ['127.0.0.0/8', '::1/128'],
	'ROLE_UMN_CAMPUS_IP': ['160.94.0.0/16', '128.101.0.0/16', '134.84.0.0/16'],
	'ROLE_ENHS_HS_IP': ['160.94.224.0/25', '128.101.60.128/25', '134.84.107.192/26'] ]

//*** END SHIBBOLETH CONFIGURATION SETTINGS ***/
