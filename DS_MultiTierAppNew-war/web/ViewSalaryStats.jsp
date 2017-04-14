<%-- 
    Document   : ViewSalaryStats
    Created on : 09.04.2017, 16:04:50
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Salary Statistics</title>
        <%@ include file="header.jsp" %>

    </head>
    <body>
        <nav>
            <div class="nav-wrapper red darken-2">
                <a class="brand-logo center">View Salary Statistics</a>
                <ul id="nav-mobile" class="right">
                    <li><a href="index.jsp">View All Users</a></li>
                </ul>
            </div>
        </nav>  
        
         <div class="row">
            <div class="col s12 m6 offset-m3">
                <% int salary = (Integer) request.getSession().getAttribute("current_salary");
                    if(salary  > 0){
                    out.println(" <h4>Employee works for " + request.getSession().getAttribute("yearsEmployed") + " in this company. "
                            + "He currently earns "  + request.getSession().getAttribute("current_salary") + " NZD ."
                    + "This is an increase of " + request.getSession().getAttribute("salaryIncrease")  + " compared to his salary in the beginning. </h4>");
                }else{
                        out.println(" <h4>No salary statistics yet</h4>");
                    }
                    
                %> 
                 
 
            </div>

        </div>
        
        

        
        
    </body>
</html>
