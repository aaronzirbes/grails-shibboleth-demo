package edu.umn.idm.demo

import grails.plugins.springsecurity.Secured

class SecureController {

	@Secured(['ROLE_USER', 'IS_AUTHENTICATED_FULLY'])
    def index = { }
}
