<%-- 
    Document   : ViewDepartment
    Created on : 7/04/2017, 9:01:43 PM
    Author     : james
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Employee Department</title>
        <%@ include file="header.jsp" %>

    </head>
    <body>
        <nav>
            <div class="nav-wrapper red darken-2">
                <a class="brand-logo center">View Employee Department</a>
                <a class="brand-logo left">Welcome, <jsp:getProperty name="user" property="userID"/>!</a>
                <ul id="nav-mobile" class="right">
                    <li><a href="index.jsp">View All Users</a></li>
                </ul>
            </div>
        </nav>  

        <jsp:useBean id="department" class="models.Department" scope="session"/>
        <jsp:useBean id="employee" class="models.Employee" scope="session"/>

        <br>
        
        <div class="row">
            <div class="col s12 m6 offset-m3">        
                <h5><% out.print("Department Information for Employee ID ");%><jsp:getProperty name="employee" property="id"/></h5>  
            </div>
        </div>        
        
        <table style="width: 75%; margin-left: 12%;">
            <thead>
                <tr>
                    <th>Department Number</th>
                    <th>Department Name</th>
                </tr>
            </thead>

            <tbody>
                <tr>
                    <td><jsp:getProperty name="department" property="id"/></td>
                    <td><jsp:getProperty name="department" property="name"/></td>
                </tr>

            </tbody>
        </table>
        <br>

    </body>
</html>
