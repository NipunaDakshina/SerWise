
<%--
  Created by IntelliJ IDEA.
  User: Nipuna
  Date: 4/19/2023
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.mysql.cj.Session" %>
<%@ page import="java.time.YearMonth" %>
<%@ page import="java.time.format.TextStyle" %>
<%@ page import="java.util.Locale" %>
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
    <title>Document</title>
</head>
<body>
<%
    String branchId=(String) request.getAttribute("branchID");
    String Month=(String) request.getAttribute("month");
    String doneAppoinment=(String) request.getAttribute("doneApp");
    String income=(String) request.getAttribute("income");
    String[] parts = Month.split("-");
    int year = Integer.parseInt(parts[0]);
    int month = Integer.parseInt(parts[1]);
    int monthYear = year * 100 + month;
    YearMonth yearMonth = YearMonth.of(monthYear / 100, monthYear % 100);
    String time=yearMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + " " + yearMonth.getYear();

%>
<header class="navigation"></header>

<div class="single-content-div center title">
    <span class="title">SerWise &MediumSpace;</span> <span class="subtitle"> - &MediumSpace; View Previous Month Report</span>
</div>
<br>
<br>

<div class="single-content-div title">
    <div>
        <span class="title">SerWise Branch - <%=branchId%></span><br>
        <span class="subtitle"><%=time%></span>
    </div>
</div>


<div class="report-table glass">
    <table>
        <tr>
            <td>
                <span class="subtitle">Appointments Done</span><br>
                <span class="title"><%=doneAppoinment%></span>
            </td>
        </tr>
        <tr>
            <td>
                <span class="subtitle">Total Income</span><br>
                <span class="title">Rs.<%=income%></span>
            </td>
        </tr>
    </table>
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
