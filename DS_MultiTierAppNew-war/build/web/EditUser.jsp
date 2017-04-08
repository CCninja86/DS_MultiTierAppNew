<%-- 
    Document   : EditUser
    Created on : 05.04.2017, 15:20:07
    Author     : Michael
    @TODO: Load Userdata to modify into inputfields!
--%>

<%@page import="models.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify User</title>

        <link rel="stylesheet" href="styles/css/materialize.min.css">
        <link rel="stylesheet" href="styles/css/styles.css">
        <script type="text/javascript" src="styles/js/jquery-2.1.1.min.js"></script>

        <script type="text/javascript" src="styles/js/materialize.min.js"></script>

    </head>
    <body>
        <jsp:useBean id="myEmployeeBean" class="stateless.EmployeeBean" scope="session"/>

        <nav>
            <div class="nav-wrapper red darken-2">
                <a class="brand-logo center">Modify User</a>
                <ul id="nav-mobile" class="right">
                    <li><a href="index.jsp">View All Users</a></li>
                </ul>
            </div>
        </nav>  

        <%
            int id = Integer.valueOf(request.getParameter("id"));

            Employee requestedEmployee = myEmployeeBean.getEmployeeById(id);

            
        %>


        <div class="row">
            <form action="ModifyUser" method="post" class="col s12">
                <div class="row">
                    <input type="hidden" name="id" value="<%out.print(id);%>" />
                    <div class="input-field col s6">
                        <input id="first_name" name="first_name" type="text" value="<% out.print(requestedEmployee.getFirstName()); %>" class="validate">
                        <label for="first_name">First Name</label>
                    </div>
                    <div class="input-field col s6">
                        <input id="last_name" name="last_name" type="text" value="<% out.print(requestedEmployee.getLastName());%>" class="validate">
                        <label for="last_name">Last Name</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col s6">
                        <label>Gender</label>
                        <select name="gender" class="browser-default">
                            <option value="" disabled selected>Choose your option</option>
                            <% if(requestedEmployee.getGender() == 'M'){
                                out.println("<option value=\"M\" selected>Male</option>");
                                out.println("<option value=\"F\">Female</option>");
                            }else{
                                out.println("<option value=\"F\" selected>Female</option>");
                                out.println("<option value=\"M\" >Male</option>");
                            }
                            %>
                            <option value="M">Male</option>
                            
                        </select>

                    </div>
                    <div class="col s6">
                        <label>Birthdate</label>
                        <input name="birthdate" value="<% out.print(requestedEmployee.getBirthDate());%>" type="date">

                    </div>
                </div>

                <div class="row">
                    <div class="col s6">
                        <label>Hire Date</label>
                        <input name="hiredate" value="<% out.print(requestedEmployee.getHireDate());%>" type="date">
                    </div>

                </div>
                <div class="row">
                    <div class="col s9">
                    </div>
                    <div class="col s3">
                        <button class="btn waves-effect waves-light red darken-2" type="submit" name="action">Submit
                        </button>

                    </div>
                </div>
            </form>
        </div>


    </body>
</html>
