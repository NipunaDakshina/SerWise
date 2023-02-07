<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.CS01.SerWise.DatabaseConnection" %>
<%@ page import="com.CS01.SerWise.Job" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../../SerWise_war/CSS/content.css">
  <link rel="stylesheet" href="../../SerWise_war/CSS/navigation.css">
  <link rel="stylesheet" href="../../SerWise_war/CSS/footer.css">
  <link rel="stylesheet" href="../../SerWise_war/CSS/background.css">
  <title>Document</title>
</head>
<header class="navigation">
  <img src="../../SerWise_war/Assets/SerWise.png" class="navimg" width="9375" height="8334">
  <table>
    <tr>
      <td><a href="../SerWise_war/SlotLeader/Home/home.jsp ">Home</a></td>
      <td><a href="../SerWise_war/SlotLeader/Jobs/jobs.jsp">Jobs</a></td>
      <td><a href="../SerWise_war/SlotLeader/CurrentJob/currentJob.jsp">Current Job</a></td>
      <td><a href="../../SerWise_war/Login/login.html"><button class="button">Logout</button></a></td>
    </tr>
  </table>
</header>

<body>

<div class="two-content-div">
  <div>

  </div>
  <div>
    <form>
      <div>
        <label>Slot Number </label><input type="number">
      </div><br>
      <div>
        <label>Slot Leader ID :</label><input type="number" >
      </div><br>
      <div>
        <label>Vehicle ID :</label><input type="text">
      </div><br>
      <div>
        <label>Job Type : </label> <input type="text">
      </div><br>
      <input type="submit" value="Confirm Job"><br>
    </form>
  </div>
</div>

</body>
<footer class="footer">
  <div class="center"><img src="../../SerWise_war/Assets/SerWise.png" class="logo"></div>
  <div class="center"><a href="#"> Contact Us </a> &nbsp|
    &nbsp<a href="#"> About Us </a> &nbsp|
    &nbsp <a href="#"> Legal Stuff </a></div>
  <div class="center">All Rights Recieved</div>
</footer>
</body>
</html>
