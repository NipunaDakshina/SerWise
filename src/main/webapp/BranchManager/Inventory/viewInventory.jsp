
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
    <span class="title">SerWise &MediumSpace;</span> <span class="subtitle"> - &MediumSpace; View Inventory List</span>
</div>


<div class="single-content-div center title">
    Search By Name : &MediumSpace;
    <form action="/SerWise_war/ServletsearchInventory">
        <input type="text" placeholder="Item Name" name="name" id="searchInput">
        <input type="submit" value="Search" class="button">
    </form>
</div>


<div class="form-display-table glass">
<table id="dataTable">
    <tr>
        <th>Item Id</th>
        <th>Name</th>
        <th>Branch Id</th>
        <th>Batch No</th>
        <th>Quantity</th>
        <th>Handling Time</th>
    </tr>
    <%
        Integer attrVal = (Integer) request.getAttribute("noOfRows");
        int noOfRows=attrVal.intValue();
        int i = 0;
        if(noOfRows !=0) {
            while (i < noOfRows) {
    %>

    <tr>
        <td><%= request.getAttribute("itemId" + i) %></td>
        <td><%= request.getAttribute("name"+i) %> </td>
        <td><%= request.getAttribute("branchId" + i) %></td>
        <td><%= request.getAttribute("batchNo" + i)%></td>
        <td><%= request.getAttribute("quantity" + i) %></td>
        <td><%= request.getAttribute("handlingTime" + i)%></td>
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
