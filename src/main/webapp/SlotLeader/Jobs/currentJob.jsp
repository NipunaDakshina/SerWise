<%--
  Created by IntelliJ IDEA.
  User: Nipuna
  Date: 4/25/2023
  Time: 6:16 PM
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
    <span class="title">SerWise &MediumSpace;</span> <span class="subtitle"> - &MediumSpace; View Current Job</span>
</div>
<%
String slotId= (String) request.getAttribute("slot"+0);
%>

<div class="form-display-table glass">
    <form action="/SerWise_war//ServletComfirmJob">
    <table>
        <% if(slotId!=null){ %>
        <tr>
            <th colspan="2">Slot Number - <%=request.getAttribute("slot"+0)%> </th>
            <input type="hidden" name="jobId" value=<%= request.getAttribute("jobId"+0)%>>
            <input type="hidden" name="slot" value=<%= request.getAttribute("slot"+0)%>>
            <input type="hidden" name="slotLeaderId" value=<%= request.getAttribute("slotLeaderId")%>>
            <input type="hidden" name="vehicleId" value=<%= request.getAttribute("vehicleId"+0)%>>
            <input type="hidden" name="date" value=<%= request.getAttribute("date"+0) %> >

        </tr>
        <tr>
            <td>Job ID :</td>
            <td><input type="text" disabled value=<%=request.getAttribute("jobId"+0)%> > </td>
        </tr>
        <tr>
            <td> Slot Leader ID : </td>
            <td><input type="text" disabled value=<%=request.getAttribute("slotLeaderId")%>> </td>
        </tr>
        <tr>
            <td> Vehicle ID : </td>
            <td><input type="text" disabled value= <%=request.getAttribute("vehicleId"+0)%>> </td>
        </tr>
        <tr>
            <td>  Job Status : </td>
            <td><input type="text" disabled value=<%=request.getAttribute("status"+0)%>> </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Confirm" class="button"></td>
        </tr>
        <% }
            else{
            %>
            <tr>
                <td colspan="2">Not Found!</td>
            </tr>
            <%
            }%>
    </table>
    </form>
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
