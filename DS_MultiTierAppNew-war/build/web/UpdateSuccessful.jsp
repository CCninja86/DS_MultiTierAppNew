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
        <title>Employee <jsp:getProperty name="employee" property="id"/>  successfully updated!</title>

        <%@ include file="header.jsp" %>
    </head>
    <body>

        <%-- Display response using employee bean properties --%>

        <jsp:useBean id="employee" class="models.Employee" scope="session"/>

        <nav>
            <div class="nav-wrapper red darken-2">
                <a class="brand-logo center">Modify User</a>
                <a class="brand-logo left">Welcome, Employee <jsp:getProperty name="user" property="userID"/>!</a>
                <ul id="nav-mobile" class="right">
                    <li><a href="index.jsp">View All Users</a></li>
                </ul>
            </div>
        </nav>  
        <div class="row">
            <div class="col s12 m6 offset-m3">
                 <h4>Employee with ID <jsp:getProperty name="employee" property="id"/> has been successfully updated</h4>
                 
                <table>
                    <thead>
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Gender</th>
                            <th>Birthdate</th>
                            <th>Hiredate</th>
                        </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <td><jsp:getProperty name="employee" property="firstName"/></td>
                            <td><jsp:getProperty name="employee" property="lastName"/></td>
                            <td><jsp:getProperty name="employee" property="gender"/></td>
                            <td><jsp:getProperty name="employee" property="birthDate"/></td>
                            <td><jsp:getProperty name="employee" property="hireDate"/></td>
                        </tr>

                    </tbody>
                </table>
            </div>

        </div>


    </body>
</html>
