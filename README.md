# MovieBaseCRUDApp
Simple Java & JSPs based Web-application for users to maintain their movie base and browse other users movie intrests. 
 - This appllication is built utilizing Spring, Hibernate (ORM) frameworks.

# Disclaimer
**This project was solely built for the learning puropse and hence does not hold any commercial value.**

**Main motivation for the creation of this project is to showcase the following knowledge:**

 - Git tool knowledge & git profile
 - Best Practices
    * MVC programing pattern
    * DRY Principles
 - Knowledge of frameworks & J2EE libraries
    * Core Spring (Spring configuration & annotation, Multipart file uploading)
    * Hibernate (ORM)
    * MySQL
    * JDBC, JSP, Servlet etc.
    * Tomcat Server

Many learning materials were referenced during the process, hence all the credit goes for:

- Java - https://docs.oracle.com/javase/8/docs/
- Stack Overflow
- GitHub
- Spring framework - https://docs.spring.io/spring/docs/current/spring-framework-reference/
- Hibernate frame work -https://hibernate.org/orm/documentation/


# Project Setup

**Requirements**
 - Tomcat Server
 - Eclipse IDE (Any IDE which supprots dynamic java based web application can be used)
 - MySQl Database server (Workbench provides GUI for MySQL)
 
 Following tutorials can be refered for installing required softwares
  - Eclipse (Windows) - https://www3.ntu.edu.sg/home/ehchua/programming/howto/EclipseJava_HowTo.html
  - Eclipse (Ubuntu/Linux) - https://linuxize.com/post/how-to-install-the-latest-eclipse-ide-on-ubuntu-18-04/
  - Eclipse (OSX/MacOS) - https://beginnersbook.com/2016/04/how-to-install-eclipse-on-mac-os-x/
  - MySQL (Windows) - https://dev.mysql.com/doc/refman/8.0/en/windows-installation.html
  - MySQL (Ubuntu/Linux) - https://support.rackspace.com/how-to/install-mysql-server-on-the-ubuntu-operating-system/
  - MySQL (OSX/MacOS) - https://dev.mysql.com/doc/mysql-osx-excerpt/5.7/en/osx-installation-pkg.html
  - Tomcat (Ubuntu/MacOS) - https://linuxize.com/post/how-to-install-tomcat-9-on-ubuntu-18-04/

**Steps to run the application:**

**Database setup**

1.) Run the SQL commands listed in  movie_base_crud_app_sql_commands.txt one by one.

**Java Project setup**

1.) Create Dynamic Web Project in Eclipse

2.) Clone the MovieBaseCRUDApp from git

3.) Copy all the packages in src and paste in the new project created

4.) Replace the folders of Web content of the project with the folders of web content from the cloned repo.

5.) Update the Database username and password in JDBChelper.java (com.spring.helper)

6.) Right click on project & select run on server.

7.) open url http://localhost:<configure_port_number>/<Project_name>/



