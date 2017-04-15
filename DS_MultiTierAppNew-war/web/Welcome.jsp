<%-- 
    Document   : Welcome
    Created on : 14/04/2017, 1:10:44 PM
    Author     : James Fraser
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="models.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="header.jsp" %>
        <title>Welcome</title>
    </head>
    <body>
        <jsp:useBean id="myEmployeeBean" class="stateless.EmployeeBean" scope="session"/>

        <nav>
            <div class="nav-wrapper red darken-2">
                <a class="brand-logo center">Welcome to Employee Manager!</a>

            </div>
        </nav>


        <br>
        <br>
        <div class="row">
            <form action="AssignUser" class="col s3 offset-s4">
                Please choose your user ID:
                <!--<input type="text" id="userID" name="userID"/>-->
                <br>
                <br>
                <select id="userID" name="userID" class="browser-default" required>
                    <option value="" disabled selected>Choose your Employee ID</option>
                    <%

                        ArrayList<Employee> employees = (ArrayList) myEmployeeBean.getEmployees(50);
                        for (Employee current : employees) {
                            out.println("<option value=" + current.getId() + ">" + current.getId() + "</option>");

                        }%>

                </select>
                <br>
                <br>                
                Please choose your preferred decimal display type:
                <br>
                <br>
                <select id="decimalType" name="decimalType" class="browser-default" required>                    
                    <option value="" disabled selected>Choose an option</option>
                    <option value="dot">.</option>
                    <option value="comma">,</option>
                </select>    
                <br>
                <br>
                <br>
                <div class="col s9">
                </div>
                <div class="col s3">

                    <button id="btnSubmit" class="btn waves-effect waves-light red darken-2" type="submit" name="action">Submit
                    </button>
                </div>
            </form>  

        </div>
    </body>
</html>
