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

<div class="single-content-div center title">
    <span class="title">SerWice &MediumSpace;</span> <span class="subtitle"> - &MediumSpace; View All Jobs</span>
</div>
<div class="single-content-div center title">
    Search By ID : &MediumSpace;
    <form>
        <input type="text" placeholder="Item Name">
        &MediumSpace;
        <input type="submit" value="Search" class="button">
    </form>
</div>


<div class="single-content-div">
    <div class="form-display-table glass">
        <table>
            <thead>
                <tr>
                    <th>Appoinment Id</th>
                    <th>Time</th>
                    <th>Date</th>
                </tr>
            </thead>
            <tbody>
            <%
                //ResultSet rs=(ResultSet) request.getAttribute("rs");

                List<Job> jobs=new ArrayList<>();
                jobs= (List<Job>) request.getAttribute("JOBS");

                for(Job theJob : jobs) {
                    int appoinmentId =theJob.getAppointmentId();
                    String date = theJob.getDate();
                    String time = theJob.getTime();

                    //Appoinmtent tempAppoinmtent = new Appoinmtent(appoinmentId, date, time, description, clientId, branchId, vehicleId);
                    //out.println(theAppoinmtent.toString());
            %>
            <tr>
                <td><%= appoinmentId %></td>
                <td><%= date %></td>
                <td><%= time %></td>
            </tr>
            <%  } %>

            </tbody>
        </table>
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
