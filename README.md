Shibboleth Test Application
===========================

This is a simple grails app to help you test and debug the configuration of Shibboleth authentication
when used with grails applications deployed to a tomcat server.

The components involved are:

* Shibboleth Native SP
* apache2
* mod_shib_22
* mod_jk
* tomcat6

Server configuration details can be found at:
---------------------------------------------
<https://wiki.umn.edu/Main/Tomcat6ServerOnUbuntuServer10_04LTS>

More helpful system configuration guides can be found at:
---------------------------------------------------------
<https://wiki.umn.edu/Main/AaronZirbes>

Once you've set up the server, set up your Shibboleth SP, Configured your Metadata and bound to a Shibboleth IdP, you can use this application to test your tomcat6 environment to make sure that Tomcat can see the shib environment variables.

