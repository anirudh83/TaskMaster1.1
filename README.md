TaskMaster1.1
=============

TaskMaster1.1

clone the repostory,
use m2Eclipse maven plugin or mvn eclipse to build project for eclipse.
Use mvn clean install to generate war.

To deploy using Tomcat plugin :
go to <tomcat-home> conf/tomcat-users.xml and add these lines :
<tomcat-users>
<role rolename="manager"/>
  <role rolename="admin"/>
  <user username="admin" password="admin" roles="admin,manager"/>
</tomcat-users>
need to do changes in m2 settings file as follows :
go to the .m2 repository and add settings.xml if not already present and add the following lines:
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0">               
    <servers>
    <server>
        <id>myserver</id>
        <username>admin</username>
        <password>admin</password>
    </server>
    </servers>
</settings>

then run tomcat and run mvn tomcat:deploy to deploy in tomcat (use mvn tomcat:redeploy for doing it again)

some Referneces :

http://www.mkyong.com/maven/how-to-create-a-web-application-project-with-maven/
http://www.mkyong.com/hibernate/quick-start-maven-hibernate-mysql-example/
http://stackoverflow.com/questions/3345816/hibernate-projects-and-building-with-maven



