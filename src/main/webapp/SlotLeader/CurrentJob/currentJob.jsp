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
    <title>Document</title>
</head>
<body>
<header class="navigation">
    <img src="../../Assets/SerWise.png" class="navimg" width="9375" height="8334">
    <table>
        <tr>
            <td><a href="../Home/home.jsp ">Home</a></td>
            <td><a href="../Jobs/jobs.jsp">Jobs</a></td>
            <td><a href="../CurrentJob/currentJob.jsp">Current Job</a></td>
            <td><a href="../../Login/login.html"><button class="button">Logout</button></a></td>
        </tr>
    </table>
</header>

<body>
<div class="two-content-div">
    <div>
        <span class="title">SerWise</span><br>
        <span class="subtitle">Current Job</span>
    </div>
    <div class="colomn-content-div">
        <form action="/SerWise_war/ViewJobs">
            <input type="hidden" name="command" value="VIEWCURRENTJOB">
            <h2 class="title">View the current job</h2>
            <p> Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                <br>Ad amet dolores ducimus eveniet impedit ipsam ipsum</p>
            <input type="submit" name="View" class="button">
        </form>
    </div>
</div>



</body>

<footer class="footer">
    <div class="center"><img src="../../Assets/SerWise.png" class="logo"></div>
    <div class="center"><a href="#"> Contact Us </a> &nbsp|
        &nbsp<a href="#"> About Us </a> &nbsp|
        &nbsp <a href="#"> Legal Stuff </a></div>
    <div class="center">All Rights Recieved</div>
</footer>
</body>
</html>
