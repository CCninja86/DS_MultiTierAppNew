<%-- 
    Document   : UpdateSuccessful
    Created on : 7/04/2017, 2:31:07 PM
    Author     : james
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Employee Updated</h3>
        
        <%-- Display response using employee bean properties --%>
        
        <jsp:useBean id="employee" class="models.Employee" scope="session"/>
        
        <p>Employee with ID <jsp:getProperty name="employee" property="id"/> has been successfully updated</p>
        <br>
        <br>
        <p>New First Name: </p><jsp:getProperty name="employee" property="firstName"/>
        <br>
        <br>
        <p>New Last Name: </p><jsp:getProperty name="employee" property="lastName"/>
        <br>
        <br>
        <p>New Gender: </p><jsp:getProperty name="employee" property="gender"/>
        <br>
        <br>
        <p>New Birth Date: </p><jsp:getProperty name="employee" property="birthDate"/>
        <br>
        <br>
        <p>New Hire Date: </p><jsp:getProperty name="employee" property="hireDate"/>
    </body>
</html>
