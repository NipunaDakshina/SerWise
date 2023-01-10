<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../CSS/content.css">
    <link rel="stylesheet" href="../../CSS/navigation.css">
    <link rel="stylesheet" href="../../CSS/footer.css">
    <link rel="stylesheet" href="../../CSS/backgrount.css">
    <title>Document</title>
</head>
<body>
<header class="navigation">
    <img src="../../Assets/SerWise.png" class="navimg">
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

<div class="two-content-div">
    <div>
        <span class="title">SerWise</span><br>
        <span>Appointments</span>
    </div>
    <div>
        <div class="colomn-content-div">
            <div>
                <form action="/SerWise_war/ViewAppoinments" >
                    <input type="hidden" name="command" value="LIST">
                    <span class="title">View Appointments</span><br>
                    <span>Make an appointment to get the best services.
                        Make an appointment to get the best services</span><br>
                    <input type="submit" value="View" class="button" />
                </form>
            </div>
            <div>
                <form action="/SerWise_war/ViewAppoinments">
                    <span class="title">Reshedule Appointments</span><br>
                    <input type="hidden" name="command" value="UPDATE">
                    <span>View your appointments here to keep track.
                            View your appointments here to keep track.</span><br>
                    <input type="submit" value="Reshedule" class="button">
                </form>
            </div>
        </div>
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