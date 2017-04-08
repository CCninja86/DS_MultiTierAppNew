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
                <ul id="nav-mobile" class="right">
                    <li><a href="index.jsp">View All Users</a></li>
                </ul>
            </div>
        </nav>  

        <jsp:useBean id="department" class="models.Department" scope="session"/>

        <br>
        <div class="valign-wrapper">
            <h5 class="valign center-align"><% out.print(department.getName());%></h5>
        </div>

        
        <br>

    </body>
</html>
