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
        
        <%@ include file="header.jsp" %>
    </head>
    <body>
        <jsp:useBean id="employee" class="models.Employee" scope="session"/>
        
        <nav>
            <div class="nav-wrapper red darken-2">
                <a class="brand-logo center">Modify User</a>
                <a class="brand-logo left">Welcome, <jsp:getProperty name="user" property="userID"/>!</a>
                <ul id="nav-mobile" class="right">
                    <li><a href="index.jsp">View All Users</a></li>
                </ul>
            </div>
        </nav>  

       
        
         <div class="row">
            <div class="col s12 m6 offset-m3">
                 <h4>Failed to Update Employee with ID <jsp:getProperty name="employee" property="id"/></h4>
                  <h5>Reason: <%= request.getAttribute("ErrorMsg") %></h5><%-- [TODO: Error Message Here] --%>
               
            </div>

        </div>
        
    </body>
</html>
