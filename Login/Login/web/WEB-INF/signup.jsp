<%-- 
    Document   : signup
    Created on : 14-Nov-2018, 16:06:24
    Author     : Mandoka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up </title>
    </head>
    <body>
        <h1>Registration</h1>
        <h3>Please enter following details to register: </h3>
         <form method="POST" action="Signup">
        <pre>
        Username: <input type="text"  name="user_name" placeholder="username" required/>
        First Name: <input type="text"  name="first_name" placeholder="first_name" required/>
        Last Name: <input type="text"  name="last_name" placeholder="last_name" required/>
        Email address: <input type="text"  name="email" placeholder="email" required/>
        Password: <input type="password"  name="user_password" placeholder="password" required/>
        Confirm Password: <input type="password"  name="user_password" placeholder="password" required/>
        Address:<input type="text"  name="address" placeholder=" " required/>
        Address: <input type="text"  name="address2" placeholder="" required/>
        Telephone number: <input type="text"  name="phone" placeholder="" required/>
       
        </pre>
    </body>
</html>
