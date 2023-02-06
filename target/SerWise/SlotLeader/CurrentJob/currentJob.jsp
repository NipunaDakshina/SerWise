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

<div class="two-content-div">
    <div>
        <form>
            <div>
                <label>Slot Number </label><input type="number" value="0012">
            </div><br>
            <div>
                <label>Slot Leader ID :</label><input type="number" value="778899" >
            </div><br>
            <div>
                <label>Vehicle ID :</label><input type="text" value="445566">
            </div><br>
            <div>
                <label>Job Type : </label> <input type="text" value="Lublicant Service">
            </div><br>
            <input type="submit" value="Confirm Job"><br>
        </form>
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
