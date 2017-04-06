<%-- 
    Document   : index
    Created on : 04.04.2017, 10:44:57
    Author     : Michael
--%>


<%@page import="models.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee View</title>

        <link rel="stylesheet" href="styles/css/materialize.min.css">
        <link rel="stylesheet" href="styles/css/styles.css">
        <script type="text/javascript" src="styles/js/jquery-2.1.1.min.js"></script>

        <script type="text/javascript" src="styles/js/materialize.min.js"></script>

    </head>
    <body>
        <jsp:useBean id="myEmployeeBean" class="stateless.EmployeeBean" scope="session"/>
          
        <nav>
            <div class="nav-wrapper red darken-2">
                <a class="brand-logo center">Employee View</a>
              
            </div>
        </nav>  


    <body>




        <table id="employeeList" class="striped centered">
            <thead>
                <tr>
                    <th>Employee ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Birth Date</th>
                    <th>Gender</th>
                    <th>Hire Date</th>
                    <th>Actions</th>
                </tr>
            </thead>

            <tbody>
                <% 
                 ArrayList<Employee> employees = (ArrayList) myEmployeeBean.getEmployees(50);
                 for (Employee current : employees) {
                    out.print("<tr>");
                    out.print("<td>" + current.getId() + "</td>");
                    out.print("<td>" + current.getFirstName() + "</td>");
                    out.print("<td>" + current.getLastName() + "</td>");
                    out.print("<td>" + current.getBirthDate() + "</td>");
                    out.print("<td>" + current.getGender() + "</td>");
                    out.print("<td>" + current.getHireDate() + "</td>");
                    out.print("<td><a href=\"EditUser.jsp?id=" + current.getId()+ "\" class=\"waves-effect waves-light btn red darken-2\">Edit employee</a><td>");
                    }%>

               
            </tbody>
        </table>

    </body>
</html>
