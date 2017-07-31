# mule-rest
The application demonstrates how to build REST API using Mule flow with the annotation-based Spring config. 
It uses Spring Data to access a MySql database, Jackson ver. 1.

The application is created to be run in Anypoint Studio on the Mule Server CE 3.8.1. 
Spring, Hibernate and Jackson were downgraded to avoid conflicts with server's libs. I didn't manage to resolve jboss Logger and Javassist version conflicts. 
The server uses jboss-logging-3.0.0.Beta5 and javassist-3.7.ga version which are not compatible with Spring 4 and Hibernate 5. 
The solution is to remove following jars:
- Anypoint_Studio_Path/plugins/org.mule.tooling.server.3.8.1/mule/libs/user/jboss-logging-3.0.0.Beta5.jar
- Anypoint_Studio_Path/plugins/org.mule.tooling.server.3.8.1/mule/libs/opt/jboss-logging-3.0.0.Beta5.jar
- Anypoint_Studio_Path/plugins/org.mule.tooling.server.3.8.1/mule/libs/user/javassist-3.7.ga.jar
- Anypoint_Studio_Path/plugins/org.mule.tooling.server.3.8.1/mule/libs/opt/javassist-3.7.ga.jar