<%--
  Created by IntelliJ IDEA.
  User: Nipuna
  Date: 4/25/2023
  Time: 6:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Nipuna
  Date: 4/19/2023
  Time: 10:46 AM
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
    <span class="title">SerWise &MediumSpace;</span> <span class="subtitle"> - &MediumSpace; View Jobs</span>
</div>


<div class="single-content-div center title">

    Search By id : &MediumSpace;
    <form action="/SerWise_war/ServletsearchJob" >
        <input type="text" placeholder="Job ID" name="id">
        &MediumSpace;
        <input type="submit" value="Search" class="button">
    </form>
</div>

<div class="form-display-table glass">
    <table>
        <tr>
            <th>Job Id</th>
            <th>Branch Id</th>
            <th>Date</th>
            <th>Time</th>
            <th>Slot</th>
            <th>Status</th>
            <th>Total</th>
            <th>Vehicle Id</th>
        </tr>
        <%
            Integer attrVal = (Integer) request.getAttribute("noOfRows");
            int noOfRows=attrVal.intValue();
            int i = 0;
            if(noOfRows !=0) {
                while (i < noOfRows) {
        %>

        <tr>
            <td><%= request.getAttribute("jobId" + i) %></td>
            <td><%= request.getAttribute("branchId" + i) %></td>
            <td><%= request.getAttribute("date" + i)%></td>
            <td><%= request.getAttribute("time" + i) %></td>
            <td><%= request.getAttribute("slot" + i) %></td>
            <td><%= request.getAttribute("status" + i) %></td>
            <td><%= request.getAttribute("total" + i)%></td>
            <td><%= request.getAttribute("vehicleId" + i) %></td>
        </tr>

        <%
                    i++;
                }
            }else{
                out.println("<tr> <td colspan=\"8\">Not Found!</td></tr>");
            }
        %>
    </table>
</div>

<footer class="footer">
    <div class="center"><img src="/SerWise_war/Assets/SerWise.png" class="logo"></div>
    <div class="center"><a href="#"> Contact Us </a> &nbsp|
        &nbsp<a href="#"> About Us </a> &nbsp|
        &nbsp <a href="#"> Legal Stuff </a></div>
    <div class="center">All Rights Recieved</div>
</footer>
<script src="/SerWise_war/SlotLeader/SlotLeaderHeader.js"></script>
</body>
</html>
