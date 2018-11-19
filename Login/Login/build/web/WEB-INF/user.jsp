<%-- 
    Document   : driver
    Created on : 01-Nov-2015, 15:18:08
    Author     : me-aydin
--%>

<%@page import="model.Jdbc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Main Page</title>
    </head>
    <body>
        <h2>User's details:</h2>
        <%! int i=0;
            String str="Register"; 
            String url = "NewUser.do";
        %>
        <%
            if((String)request.getAttribute("msg")=="del") {
                str = "Delete";
                url = "Delete.do";
            }
            else {
                str="Register";
                url = "NewUser.do";
            } 
        %>
        <form method="POST" action="<%=url%>">     
            <table>
                <tr>
                    <th></th>
                    <th>Please provide your following details</th>
                </tr>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="user_name" required/></td>
                </tr>
                 <tr>
                    <td>Address:</td>
                    <td><input type="text" name="user_address" required/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="user_password" required/></td>
                </tr>
                 <tr>
                    <td>ID:</td>
                    <td><input type="text" name="user_id" required/></td>
                </tr>
                <tr>
                    <td>User type</td>
                    <td>  <select type="text" name ="usertype">
                            <option>Customer</option>
                            <option>Driver</option>
                            <option>Administrator</option>
                        </select> </td>
                    
                </tr>
                <tr> 
                    <td> <input type="submit" value="<%=str%>"/></td>
                </tr>
            </table>
        </form>   
        <%
            if (i++>0 && request.getAttribute("message")!=null) {
                out.println(request.getAttribute("message"));
                i--;
            }
        %>
        </br>
        <jsp:include page="foot.jsp"/>
    </body>
</html>
