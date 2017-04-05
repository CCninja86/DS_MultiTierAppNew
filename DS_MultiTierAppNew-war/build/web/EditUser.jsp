<%-- 
    Document   : EditUser
    Created on : 05.04.2017, 15:20:07
    Author     : Michael
    @TODO: Load Userdata to modify into inputfields!
--%>

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
        <nav>
            <div class="nav-wrapper red darken-2">
                <a class="brand-logo center">Modify User</a>
                <ul id="nav-mobile" class="right">
                    <li><a href="index.jsp">View All Users</a></li>
                </ul>
            </div>
        </nav>  





        <div class="row">
            <form class="col s12">
                <div class="row">
                    <div class="input-field col s6">
                        <input id="first_name" type="text" class="validate">
                        <label for="first_name">First Name</label>
                    </div>
                    <div class="input-field col s6">
                        <input id="last_name" type="text" class="validate">
                        <label for="last_name">Last Name</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col s6">
                        <label>Gender</label>
                        <select class="browser-default">
                            <option value="" disabled selected>Choose your option</option>  
                            <option value="M">Male</option>
                            <option value="F">Female</option>
                        </select>

                    </div>
                    <div class="col s6">
                        <label>Birthdate</label>
                        <input type="date">

                    </div>
                </div>

                <div class="row">
                    <div class="col s6">
                        <label>Hire Date</label>
                        <input type="date">
                    </div>

                </div>
                <div class="row">
                    <div class="col s9">
                    </div>
                    <div class="col s3">
                        <a href="ModifyUser" class="waves-effect waves-light btn red darken-2">Submit</a>
                    </div>
                </div>
            </form>
        </div>


    </body>
</html>
