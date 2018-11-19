<%-- 
    Document   : login
    Created on : 11-Nov-2018, 17:03:50
    Author     : Monika Pusz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> <jsp:include page="header.jsp"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login </title>
    </head>
    <body>
        <br>
        <h1>Taxi Booking System</h1>
        <h3>Log in: </h3>
         <form method="POST" action="LoginPage">
        <pre>
        <td>Username: </td><input type="text"  name="user_name" placeholder="username" required/>
        <td>Password: </td><input type="password"  name="user_password" placeholder="password" required/>
        <td>User type: </td><select type="text" name ="user_type">
        <option>Customer</option>
        <option>Driver</option>
        <option>Admin</option>
        </select>
        
        <input type="submit"  value="Log in"/>
       
        </pre>
             
             <%
            if (request.getAttribute("message")!=null) {
                out.println(request.getAttribute("message"));
              }
        %>
    </body>
</html>
