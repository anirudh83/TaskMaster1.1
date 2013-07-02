TaskMaster1.1
=============

TaskMaster1.1

The project is build using maven.
It uses mvn tomcat plugin.

After checking out :
1. create a blank database in mysql with name taskmaster => create database taskmaster;
2. run mvn clean install to build the project
3. run mvn tomcat:run to run the project
4. http://localhost:8080/TaskMaster


In order to deploy this app on openshift see this blog :
http://anirudhbhatnagar.wordpress.com/2013/06/17/adding-my-spring-mvc-hibernate-app-to-openshift/
