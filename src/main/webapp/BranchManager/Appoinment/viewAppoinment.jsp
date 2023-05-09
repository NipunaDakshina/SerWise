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
<%

%>
<header class="navigation"></header>


<div class="single-content-div center title">
    <span class="title">SerWise &MediumSpace;</span> <span class="subtitle"> - &MediumSpace; View Appoinments</span>
</div>


<div class="single-content-div center title">
    Search By id : &MediumSpace;
    <form action="/SerWise_war/ServletsearchAppoinment" >
        <input type="text" placeholder="Appoinment ID" name="id">
        &MediumSpace;
        <input type="submit" value="Search" class="button">
    </form>

    Search By date : &MediumSpace;
    <form action="/SerWise_war/ServletsearchAppoinment">
        <input type="date" placeholder="Appoinment Date" name="date">
        &MediumSpace;
        <input type="submit" value="Search" class="button">
    </form>

</div>


<form id="myForm" action="/SerWise_war/ServletlistAppoinment" method="post">
    <input type="hidden" name="command" value="list">
</form>

<div class="form-display-table glass">
    <table>
<tr>
    <th>Appoinment Id</th>
    <th>Date</th>
    <th>Time</th>
    <th>Description</th>
    <th>ClientId</th>
    <th>BranchId</th>
    <th>VehicleId</th>
    <th colspan="2">Manage Options</th>
</tr>
<%
            Integer attrVal = (Integer) request.getAttribute("noOfRows");
            int noOfRows=attrVal.intValue();
            int i = 0;
            if(noOfRows !=0) {
                while (i < noOfRows) {
                    %>

        <tr>
                <td><%= request.getAttribute("appoinmentId" + i) %></td>
                <td><%= request.getAttribute("date" + i) %></td>
                <td><%= request.getAttribute("time" + i)%></td>
                <td><%= request.getAttribute("desription" + i) %></td>
                <td><%= request.getAttribute("clientId" + i)%></td>
                <td><%= request.getAttribute("branchId" + i) %></td>
                <td><%= request.getAttribute("vehicleId" + i) %></td>
        <td>
            <form action="/SerWise_war/BranchManager/Appoinment/reshedule.jsp">
                <input type="hidden" name="id" value=<%=request.getAttribute("appoinmentId" + i)%>>
                <input type="hidden" name="date" value=<%=request.getAttribute("date" + i)%>>
                <input type="hidden" name="time" value=<%=request.getAttribute("time" + i)%>>
                <input type="submit" class="button" value="Reshedule">

            </form>

        </td>
        <td>
            <form action="/SerWise_war/BranchManager/Appoinment/remove.jsp">
                <input type="hidden" name="id" value=<%=request.getAttribute("appoinmentId" + i) %>>
                <input type="hidden" name="date" value=<%=request.getAttribute("date" + i)%>>
                <input type="hidden" name="time" value=<%=request.getAttribute("time" + i)%>>
                <input type="submit" class="button" value="Remove">
            </form>

        </td>
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