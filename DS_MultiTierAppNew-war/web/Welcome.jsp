<%-- 
    Document   : Welcome
    Created on : 14/04/2017, 1:10:44 PM
    Author     : james
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <h1>Welcome!</h1>
        <br>
        <br>
        <form action="AssignUser">
            Please enter your user ID:
            <input type="text" id="userID" name="userID"/>
            <br>
            <br>
            <input type="submit" id="btnSubmit"/>
        </form>        
    </body>
</html>
