# Java-E-commerce-Platform-Project

Tools:
1. Java EE(Tomcat Server, Java Servlet, JSP, JavaSE, JDBC)
2. SQL(MySQL Database)
3. XML
4. JavaScript, HTML, CSS

Architecture:

![](README_files/1.png)


Main Features:
1. Project demand breakdown and basic environment construction
2. The actual development process of the user module
3. Standard project registration and login process implementation
4. Front menu design and implementation of classification module
5. Commodity module and front-end merchandise display design and implementation
6. Design and implementation of shopping process



day 1:
1. Create User Infromation table and import to the MySQL 
![](README_files/3.jpg)
2. User Module(CRUD)
3. coded jsp sevelet userDao to achieve user update MySQL

day 2:
1. coded query from the MySql
2. split the pages for ResultSet
3. query based on user search
![](README_files/10.jpg)

day 3:
1. coded user information modifier

day 4:
1. coded delete one record or multiple records

day 5:
1. update user registration UI
![](README_files/1.jpg)
![](README_files/2.jpg)


day 6:
1. implemneted verification generator
2. updated the front-end verification

day 7:
1. implmented js code check username password repassword and verify code is not null
2. implmented Ajax code check the use_ID unique (connect MySQL check) and verify code correction.

![](README_files/4.jpg)
![](README_files/5.jpg)

3/22:
1. Front-end Verification finished

3/24
1. Add the servlet filter to check the informmation correctness
2. Implemented the Login page(Login.jsp login.sevelet)
3. Modified the Personal Information Page
![](README_files/6.jpg)
![](README_files/7.jpg)
4. Impemented normal user login(Login servlet) logout(logout servlet)

3/25
1. Modified the administrator login(login Servlet) logout(logout servlet)
![](README_files/8.jpg)
![](README_files/9.jpg)
2. Implemented the administrator filter to protect administrator web page need login to access.

3/26
1. Create the category table and immport to the Mysql database
![](README_files/11.jpg)