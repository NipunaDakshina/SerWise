<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<%@ page import="java.util.*,com.CS01.SerWise.*" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.io.PrintWriter" %>
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
  <link rel="stylesheet" href="/SerWise_war/CSS/popup.css">

  <title>Document</title>
</head>
<body>
<header class="navigation"></header>

<div class="single-content-div center title">
  <span class="title">SerWise &MediumSpace;</span> <span class="subtitle"> - &MediumSpace; Find Previous Report</span>
</div>


<div class="two-content-div glass">
  <div class="single-content-div center title">
    <div class="single-content-div-form glass">
      <form action="/SerWise_war/ServletviewPreviousReport">

        <label>Select month </label>
        <input type="month" name="month">
        <input type="submit" value="Find Report" class="button">
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
