<%-- 
    Document   : index
    Created on : 04.04.2017, 10:44:57
    Author     : Michael
--%>


<%@page import="java.text.SimpleDateFormat"%>
<%@page import="models.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Employee View</title>

        <%@ include file="header.jsp" %>

        <script type="text/javascript" src="styles/js/jquery.tablesorter.min.js"></script>

      
    </head>
    <body>
        <jsp:useBean id="myEmployeeBean" class="stateless.EmployeeBean" scope="session"/>
        <jsp:useBean id="user" class="models.User" scope="session"/>
        

        <nav>
            <div class="nav-wrapper red darken-2">
                <a class="brand-logo center">Employee View</a>
                <a class="brand-logo left userIdentifier">Welcome, Employee <jsp:getProperty name="user" property="userID"/>!</a>
            </div>
        </nav>  


    <body>
        <table id="employeeList" class="striped centered tablesorter">
            <thead>
                <tr>
                    <th class="header">Employee ID </th>
                    <th class="header">First Name</th>
                    <th class="header">Last Name</th>
                    <th class="header">Birth Date</th>
                    <th class="header">Gender</th>
                    <th class="header">Hire Date</th>
                    <th>Actions</th>
                </tr>
            </thead>

            <tbody>
                <%                    
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                    
                    ArrayList<Employee> employees = (ArrayList) myEmployeeBean.getEmployees(50);
                    for (Employee current : employees) {
                        out.print("<tr>");
                        out.print("<td>" + current.getId() + "</td>");
                        out.print("<td>" + current.getFirstName() + "</td>");
                        out.print("<td>" + current.getLastName() + "</td>");
                        out.print("<td>" + sdf.format(current.getBirthDate()) + "</td>");
                        out.print("<td>" + current.getGender() + "</td>");
                        out.print("<td>" + sdf.format(current.getHireDate()) + "</td>");
                        
                        out.print("<td><a href=\"EditUser.jsp?id=" + current.getId() + "\" class=\"waves-effect waves-light btn red darken-2\">Edit employee</a>"
                                + "<a href=\"GetDepartment?id=" + current.getId() + "\" class=\"waves-effect waves-light btn red darken-2\" style=\"margin-left: 5px\">View Department</a>"
                                        + "<a href=\"GetSaleriesStats?id=" + current.getId() + "&userDecimalPref=" + user.getDecimalType() + "\" class=\"waves-effect waves-light btn red darken-2\" style=\"margin-left: 5px\">View salary stats</a><td>");
                    }%>


            </tbody>
        </table>
        <script>
            $(document).ready(function ()
            {
                $("#employeeList").tablesorter({headers: {6: {sorter: false}}});
            }
            );

        </script>
    </body>
</html>
