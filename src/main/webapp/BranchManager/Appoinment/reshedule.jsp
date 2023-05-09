<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<%@ page import="java.util.*,com.CS01.SerWise.*" %>
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

<header class="navigation"></header>

<div class="single-content-div center title">
  <span class="title">SerWise &MediumSpace;</span> <span class="subtitle"> - &MediumSpace; Reshedule Appoinment Confirmation</span>
</div>

<%
  String id=(String)request.getParameter("id");
  String date=(String) request.getParameter("date");
  String time=(String) request.getParameter("time");
  PrintWriter pw=response.getWriter();
%>

<div class="two-content-div">
  <div class="single-content-div center title">
    <div class="single-content-div-form glass">
        <form action="/SerWise_war/ServletresheduleAppoinment">
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
            <input type="date" name="new_date" required id="resheduleDate" >
            <label>To which time</label>
            <input type="time" name="new_time" required min="08:00" max="20:00">
            <input type="submit" value="Confirm" class="button" onclick="checkDate()">
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

<script src="/SerWise_war/BranchManager/BranchManagerHeader.js"></script>

<script>
    //check whether user entered date is valid or not
    function checkDate() {
        var inputDate = new Date(document.getElementById("resheduleDate").value); // Convert the input date string to a Date object
        var currentDate = new Date(); // Get the current date
        if (inputDate < currentDate) { // Compare the input date to the current date
            alert("Please select a future date");
        }
    }
</script>
</body>
</html>
