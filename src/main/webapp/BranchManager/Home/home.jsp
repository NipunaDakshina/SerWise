<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.CS01.SerWise.DatabaseConnection" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../../CSS/content.css">
  <link rel="stylesheet" href="../../CSS/navigation.css">
  <link rel="stylesheet" href="../../CSS/footer.css">
  <link rel="stylesheet" href="../../CSS/background.css">
  <link rel="stylesheet" href="../../CSS/Style/grid.css">
  <title>Document</title>
</head>
<body>
<header class="navigation">
  <img src="../../Assets/SerWise.png" class="navimg" width="9375" height="8334">
  <table>
    <tr>
      <td><a href="../Home/home.jsp ">Home</a></td>
      <td><a href="../Appoinments/appointments.jsp">Appointments</a></td>
      <td><a href="../Reports/reports.html">Reports</a></td>
      <td><a href="../Inventory/inventory.html">Inventory</a></td>
      <td><a href="../../Login/login.html"><button class="button">Logout</button></a></td>
    </tr>
  </table>
</header>
<%
  //this section is used for defining session store for banch manager details
  int employeeId=(Integer)session.getAttribute("employeeId");
  int branchId=(Integer) session.getAttribute("branchId");
  //out.println(employeeId);
  //out.println(branchId);



%>
<div class="grid-content">
  <div class="div-content-1">1</div>
  <div class="div-content-2">2</div>
  <div class="div-content-3">3</div>
  <div class="div-content-4">
    <img src="../../Assets/img/img-2.jpg">
  </div>
</div>


<footer class="footer">
  <div class="center"><img src="../../Assets/SerWise.png" class="logo"></div>
  <div class="center"><a href="#"> Contact Us </a> &nbsp|
    &nbsp<a href="#"> About Us </a> &nbsp|
    &nbsp <a href="#"> Legal Stuff </a></div>
  <div class="center">All Rights Recieved</div>
</footer>
</body>
</html>
