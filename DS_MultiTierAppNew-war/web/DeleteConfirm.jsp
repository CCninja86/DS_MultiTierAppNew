<%-- 
    Document   : DeleteConfirm
    Created on : 15/04/2017, 12:01:59 PM
    Author     : james
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Delete?</title>
        
        <%@ include file="header.jsp" %>
        
    </head>
    <body>
        <%
            int id = Integer.valueOf(request.getParameter("id"));
        %>
        <h3 style="text-align: center">Are you sure you want to delete Employee ID <% out.print(id); %>?</h1>
        <br>
        <br>
        <a href="index.jsp" class="btn waves-effect waves-light red darken-2" type="submit" style="position: relative; left: 45%">No</a>
        <a href="DeleteEmployee?id=<% out.print(id); %>" class="btn waves-effect waves-light red darken-2" type="submit" style="position: relative; left: 45%">Yes</a>        
    </body>
</html>
