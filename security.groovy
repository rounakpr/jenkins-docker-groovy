#!groovy

import jenkins.model.*
import hudson.security.*
import jenkins.security.s2m.AdminWhitelistRule
import jenkins.model.JenkinsLocationConfiguration
import net.sf.json.JSONObject

import jenkins.security.QueueItemAuthenticatorConfiguration
import org.jenkinsci.plugins.authorizeproject.GlobalQueueItemAuthenticator
import org.jenkinsci.plugins.authorizeproject.strategy.TriggeringUsersAuthorizationStrategy

println("======== Configuring users =========")

# JenkinsLocationConfiguration class Stores the location of Jenkins (e-mail address and the HTTP URL.)
def instance = Jenkins.getInstance()
String admin_email = 'admin@testmail.com'
JenkinsLocationConfiguration location = instance.getExtensionList('jenkins.model.JenkinsLocationConfiguration')[0]

# Create admin account while setting up jenkins
def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount("admin", "admin")

# class FullControlOnceLoggedInAuthorizationStrategy extends AuthorizationStrategy that grants full-control to authenticated user and optionally read access to anonymous users
def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
instance.setAuthorizationStrategy(strategy)

# class Jenkins (Ref: https://javadoc.jenkins-ci.org/jenkins/model/Jenkins.html)
Jenkins.instance.getInjector().getInstance(AdminWhitelistRule.class).setMasterKillSwitch(false)
println "Updating Jenkins Email to: ${admin_email}"
location.adminAddress = admin_email
instance.save()
location.save()
