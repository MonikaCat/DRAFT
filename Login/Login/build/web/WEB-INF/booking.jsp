<%-- 
    Document   : home
    Created on : 17-Nov-2018, 17:41:54
    Author     : Mandoka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alphacab Taxi </title>
        
    </head>
    <body>
       
        
      <h1>Taxi Booking System</h1>
        <form method="POST" action="Booking">
        <img src="WEB-INF/img/booking.png" alt="HOME"> 
        <div class="form-group">
	<span class="form-label">Name</span>
	<input class="form-control" name="name" type="text" placeholder="Full name"> </div>
        <div class="form-group">
	<span class="form-label">Email</span>
	<input class="form-control" name="email" type="text" placeholder="Email"></div>
        <div class="form-group">
	<span class="form-label">Phone</span>
	<input class="form-control" name ="phone" type="text" placeholder="Phone number">
	</div>
        <div class="form-group">
	<span class="form-label">Pickup Location</span>
	<input class="form-control" name ="pickup" type="text" placeholder="Pickup Location">
	</div>
        <div class="form-group">
	<span class="form-label">Dropoff Location</span>
	<input class="form-control" name ="dropoff" type="text" placeholder="Dropoff Location">
	</div>
         <div class="form-group">
	<span class="form-label">Pickup Date</span>
	<input class="form-control" name="date" type="text" required>
	</div>   
        <div class="form-group">
	<span class="form-label">Hour</span>
	<select class="form-control" name= "time" type="text">
	<option>1</option>
	<option>2</option>
	<option>3</option>
	<option>4</option>
	<option>5</option>
	<option>6</option>
	<option>7</option>
	<option>8</option>
	<option>9</option>
	<option>10</option>
	<option>11</option>
	<option>12</option>
	</select>
	<span class="select-arrow"></span>
        </div>
        <div class="form-group">
	<span class="form-label">Min</span>
	<select class="form-control" name="time" type="text">
	<option>05</option>
	<option>10</option>
	<option>15</option>
	<option>20</option>
	<option>25</option>
	<option>30</option>
	<option>35</option>
	<option>40</option>
	<option>45</option>
	<option>50</option>
	<option>55</option>
	</select>
	<span class="select-arrow"></span>
	</div>
        <div class="form-group">
	<span class="form-label">AM/PM</span>
	<select class="form-control">
	<option>AM</option>
	<option>PM</option>
	</select>
	<span class="select-arrow"></span>
	</div>
            
        <div class="form-group">
	<span class="form-label">Registration</span>
	<input class="form-control" name ="reg" type="text" placeholder="Registration">
	</div>
            <div class="form-group">
	<span class="form-label">USER ID</span>
	<input class="form-control" name ="userid" type="text" placeholder="user id">
	</div>
            <div class="form-group">
	<span class="form-label">JOURNEY ID</span>
	<input class="form-control" name ="jid" type="text" placeholder="journey id">
	</div>
            
        <div class="form-btn">
	<button class="submit-btn">Book Now</button>
	</div>
	
        </form> 
        <br>
        
        <jsp:include page="foot.jsp"/>
        
          <%
            if (request.getAttribute("message")!=null) {
                out.println(request.getAttribute("message"));
              }
        %>
        
    </body>
</html>
