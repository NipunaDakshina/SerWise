<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<%@ page import="java.util.*,com.CS01.SerWise.*" %>
<%@ page import="com.CS01.SerWise.Appoinmtent" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="/SerWise_war/CSS/content.css">
  <link rel="stylesheet" href="/SerWise_war/CSS/navigation.css">
  <link rel="stylesheet" href="/SerWise_war/CSS/footer.css">
  <link rel="stylesheet" href="/SerWise_war/CSS/backgrount.css">
  <link rel="stylesheet" href="/SerWise_war/CSS/popup.css">

  <title>Document</title>
</head>
<body>
<header class="navigation">
  <img src="/SerWise_war/Assets/SerWise.png" class="navimg">
</header>

<%
  String id=(String)request.getParameter("id");
  String date=(String) request.getParameter("date");
  String time=(String) request.getParameter("time");
  PrintWriter pw=response.getWriter();




%>

<div class="two-content-div">
  <div class="single-content-div center title">
    <div class="single-content-div-form">
      <form action="/SerWise_war/AppoinmentController">
        <input type="hidden" name="command" value="RESHEDULE">

        <input type="hidden" name="id" value=<%=id%>>
        <input type="hidden" name="old_date" value=<%=date%> >
        <input type="hidden" name="old_time" value=<%=time%> >

        <label>Appoinment ID</label>
        <input type="text" name="id" value=<%=id %> disabled>
        <label>Date to be resheduled </label>
        <input type="text" value=<%= date%> disabled>
        <label>Time to be resheduled</label>
        <input type="text" value=<%=time%> disabled>
        <label>To which date</label>
        <input type="date" name="new_date">
        <label>To which time</label>
        <input type="time" name="new_time">
        <input type="submit" value="Confirm" class="button">
        <div class="clear"></div>
        <div>
          <button type="button" class="button" ><a href="/SerWise_war/AppoinmentController?command=LIST" style=" text-decoration: none; color: black;">Cancel</a></button>
        </div>
      </form>
      </div>
  </div>
</div>


<footer class="footer">
  <div class="center"><img src="/SerWise_war/Assets/SerWise.png" class="logo"></div>
  <div class="center"><a href="#"> Contact Us </a> &nbsp|
    &nbsp<a href="#"> About Us </a> &nbsp|
    &nbsp <a href="#"> Legal Stuff </a></div>
  <div class="center">All Rights Recieved</div>
</footer>
</body>

<script>



</script>


</html>
