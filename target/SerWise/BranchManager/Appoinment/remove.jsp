<%--
  Created by IntelliJ IDEA.
  User: Nipuna
  Date: 3/7/2023
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
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
    <span class="title">SerWise &MediumSpace;</span> <span class="subtitle"> - &MediumSpace; Remove Appoinment Confirmation</span>
</div>

<%
    String id=(String)request.getParameter("id");
    String date=(String) request.getParameter("date");
    String time=(String) request.getParameter("time");
    PrintWriter pw=response.getWriter();
%>

<div class="single-content-div">
    <div class="single-content-div center title">
        <div class="single-content-div-form glass">
            <form action="/SerWise_war/ServletremoveAppoinment">
                <input type="hidden" name="command" value="REMOVE">
                <input type="hidden" name="id" value=<%=id%>>
                <label>Appoinment ID</label>
                <input type="text" name="id" value=<%=id %> disabled>
                <label>Date</label>
                <input type="text" value=<%= date%> disabled>
                <label>Time</label>
                <input type="text" value=<%=time%> disabled>
                <input type="submit" value="Confirm" class="button">
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

</body>
</html>
