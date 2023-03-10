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
  <link rel="stylesheet" href="../../CSS/Style/content.css">
  <title>Document</title>
</head>
<body>
<header class="navigation">
  <img src="../../Assets/SerWise.png" class="navimg" width="9375" height="8334">
  <table>
    <tr>
      <td><a href="../SerWise_war/Home/home.jsp">Home</a></td>

        <td>
          <a href="/SerWise_war/AppoinmentController?command=LIST">Appoinments</a>
        </td>

      <td><a href="/SerWise_war/BranchManager/Reports/reports.jsp">Reports</a></td>

        <td>
          <a href="/SerWise_war/InventoryController?command=LIST">Inventory</a>
        </td>

      <td><a href="../../SerWise_war/Login/login.html"><button class="button">Logout</button></a></td>
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

<div class="home-first-content">
  <div>
    <span class="title">SerWise</span><br>
    <span>We Care About Your Vehicle</span><br>
  </div>
</div>




<div class="two-content-div glass">
  <div>
    <img src="../../Assets/HomeLastContentDiv.jpg" class="content-div-img">
  </div>
  <div>
    <span class="title">Best service in Sri Lanka</span><br>
    <span>Nemo enim ipsam voluptatem quia voluptas sit aspernatur
                 aut odit aut fugit, sed quia consequuntur magni dolores
                  eos qui ratione voluptatem sequi nesciunt.
                  Neque porro quisquam est, qui dolorem.</span>
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
