<%-- 
    Document   : UpdateUnsuccessful
    Created on : 7/04/2017, 2:31:18 PM
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
        <jsp:useBean id="employee" class="models.Employee" scope="session"/>
        
        <nav>
            <div class="nav-wrapper red darken-2">
                <a class="brand-logo center">Modify User</a>
                <ul id="nav-mobile" class="right">
                    <li><a href="index.jsp">View All Users</a></li>
                </ul>
            </div>
        </nav>  
        
        <h1>Employee Not Updated</h1>
        <br>
        <br>
        <h1>Failed to Update Employee with ID <jsp:getProperty name="employee" property="id"/></h1>
        <br>
        <br>
        <p>Reason: </p><%-- [TODO: Error Message Here] --%>
    </body>
</html>
