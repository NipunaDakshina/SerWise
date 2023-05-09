<%--
  Created by IntelliJ IDEA.
  User: Nipuna
  Date: 5/9/2023
  Time: 2:39 PM
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
<%

%>
<header class="navigation"></header>


<div class="single-content-div center title">
    <span class="title">SerWise &MediumSpace;</span> <span class="subtitle"> - &MediumSpace; View Branch Employee Details</span>
</div>



<div class="form-display-table glass">
    <table>
        <tr>
            <th>Employee Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Address</th>
            <th>Phone No</th>
            <th>Email</th>
            <th>Position</th>

        </tr>
        <%
            Integer attrVal = (Integer) request.getAttribute("noOfRows");
            int noOfRows=attrVal.intValue();
            int i = 0;
            if(noOfRows !=0) {
                while (i < noOfRows) {
        %>

        <tr>
            <td><%= request.getAttribute("employeeId" + i) %></td>
            <td><%= request.getAttribute("firstName" + i) %></td>
            <td><%= request.getAttribute("lastName" + i)%></td>
            <td><%= request.getAttribute("address" + i) %></td>
            <td><%= request.getAttribute("phoneNo" + i)%></td>
            <td><%= request.getAttribute("email" + i) %></td>
            <td><%= request.getAttribute("position" + i) %></td>
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
<script src="/SerWise_war/BranchManager/BranchManagerHeader.js"></script>
</body>
</html>