TaskMaster1.1
===============

TaskMaster1.1
IT is a tasks management system. It is built using :
1.)Spring 3 MVC
2.)Spring DI
3.)REST support for Spring MVC
4.)Twitter Bootstrap API
5.)Hibernate 3
6.)MySQL 5
7.)Tomcat 7


The project is build using maven.
It uses mvn tomcat plugin.

After checking out :
1. create a blank database in mysql with name taskmaster => create database taskmaster;
2. run mvn clean install to build the project
3. run mvn tomcat:run to run the project
4. http://localhost:8080/TaskMaster


In order to deploy this app on openshift see this blog :
http://anirudhbhatnagar.wordpress.com/2013/06/17/adding-my-spring-mvc-hibernate-app-to-openshift/
