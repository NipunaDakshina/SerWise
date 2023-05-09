<%--
  Created by IntelliJ IDEA.
  User: Nipuna
  Date: 4/19/2023
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.mysql.cj.Session" %>
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

<header class="navigation"></header>

<div class="single-content-div center title">
    <span class="title">SerWise &MediumSpace;</span> <span class="subtitle"> - &MediumSpace; View Report</span>
</div>

<div class="two-content-div glass">
    <div>
        <div class="colomn-content-div">
            <form action="/SerWise_war/ServletviewCurrentMonthReport">
                <div>
                    <span class="title">View Current Month Status</span><br>
                    <span>current month view report summarizes number of appoinments that are done and
                    ongoing and Total income of the month</span><br>
                    <input type="submit" class="button" value="View">
                </div>
            </form>

            <form action="/SerWise_war/BranchManager/Report/findReport.jsp">
                <div>
                    <span class="title">View Previous Reports</span><br>
                    <span>previous month report summarizes number of appoinments that are done and billed and
                     Total income of that month</span><br>
                    <input type="submit" class="button" value="View">
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
<script src="/SerWise_war/BranchManager/BranchManagerHeader.js"></script>
</body>
</html>
