package edu.umn.idm.demo

class MenuController {

	def springSecurityService

    def index = {
		def auth = springSecurityService.authentication

		def token = auth.class.toString()
		def username = ''
		def authorities = ''
		def authenticated = ''

		if (auth.class.toString().contains('AnonymousAuthenticationToken') ) {
			username = 'ANONYMOUS'
		} else {
			username = auth["username"]
			authorities = auth["authorities"]
			authenticated = auth["authenticated"]
		}

		[ token: token,
		username: username,
		authorities: authorities,
		authenticated: authenticated ]
	}
}
