/***************
 * Cloud configuration file for the CloudStack cloud. Uses the default jclouds-based cloud driver.
 * @author Noel King
 *
 */

cloud {
	name = "cloudstack"

	configuration {
		className "org.cloudifysource.esc.driver.provisioning.jclouds.DefaultProvisioningDriver"
		managementMachineTemplate "SMALL_LINUX"
		connectToPrivateIp true
		bootstrapManagementOnPublicIp false
	}

	provider {
		provider "cloudstack"
		cloudifyUrl "http://repository.cloudifysource.org/org/cloudifysource/2.3.0-RELEASE/gigaspaces-cloudify-2.3.0-ga-b3500"
		machineNamePrefix "maddev"
		dedicatedManagementMachines true
		managementOnlyFiles ([])
		sshLoggingLevel "WARNING"
		managementGroup "cloudifymgr"
		numberOfManagementMachines 1
		reservedMemoryCapacityPerMachineInMB 1024
	}

	user {
		apiKey "v000000000000000000CQloheSokzTfllFut5t99dlYaMxg"
		user "v000000000000000000CQloheSokzTfllFut5t99dlYaMxg"
	}

	templates ([
				SMALL_LINUX : template{
					imageId "7ecaa903-b87e-4577-ae57-b66419e314e2"
					remoteDirectory "/opt"
					machineMemoryMB 1600
					hardwareId "d7a6065a-e8d6-49e2-8ee8-d85763054721"
					localDirectory "upload"

					username "root"
					password "<YOUR PASSWORD>"					
					overrides ([
						"securityGroups" : ["b8883432-ffc2-4719-b3f0-efc2ad234639"]as String[],
						"jclouds.endpoint":"http://192.168.1.88:8099/"
					])
				}
		])
}