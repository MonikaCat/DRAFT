<%-- 
    Document   : adminhome
    Created on : 18-Nov-2018, 14:41:09
    Author     : Monika Pusz
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><jsp:include page="header.jsp"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADMIN HOME PAGE </title>
    </head>
    <body>
        
        <%
 
            if(request.getSession().getAttribute("user_details") == null) {
                request.setAttribute("login", true);
                request.getRequestDispatcher("UserService.do").forward(request, response);
            }

            if (request.getSession().getAttribute("user_details") != null)
            {
             List<String> values = (ArrayList)request.getSession().getAttribute("user_details");
             String user_name = values.get(0).toString();
             System.out.println("USERNAME " + user_name);
             String user_type = values.get(1).toString();
             System.out.println("USER TYPE " + user_type);
                //if(request.getSession().getAttribute(user_name) == "admin" & request.getSession().getAttribute(user_type) == "Admin"  )
                if(values.get(0).equals("admin") & values.get(1).equals("Admin"))
                {
                 System.out.println("WE REACH HERE");
                 System.out.println(request.getSession().getAttribute("user_details"));
                 //System.out.println(values.get(0) + " HERE ");
        %>


        <h1>ADMIN HOME</h1>
        <form method="POST" action="UserService.do">
        <p />
            View a table <br />
            <input type="radio" name="tbl" value="List">List All Users<br />
            <input type="radio" name="tbl" value="NewUser">Create New User<br />
            <input type="radio" name="tbl" value="ListDrivers">List All Drivers<br />
            <input type="radio" name="tbl" value="NewDriver">Create New Driver<br />
            <input type="radio" name="tbl" value="DeleteUser">Delete a User<br />
            <input type="radio" name="tbl" value="DeleteDriver">Delete a Driver<br />
            <input type="radio" name="tbl" value="ListBookings">List All Bookings <br />
            <input type="radio" name="tbl" value="ChangeBooking">Change Booking<br />
            <input type="radio" name="tbl" value="DailyReport">Daily Report<br />
            <!--<input type="radio" name="tbl" value="Delete">Delete a User<br /> !-->
            <input type="radio" name="tbl" value="Book">Book car<br />
            <input type="radio" name="tbl" value="Admin">SHOW ADMIN<br />
            <input type=submit value="Confirm"> <br />
        </form> 
        <br>
        <br>
        <jsp:include page="foot.jsp"/>
        <br>
        <form action="Logout">
    <input type="submit" value="Log out" />
        </form>
        
        <%
            }
        else 
        {
                System.out.println("YOU ARE NOT ADMIN");
                request.getRequestDispatcher("/WEB-INF/noaccess.jsp").forward(request, response);
        }

        }
        %>
    </body>
</html>
