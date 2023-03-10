<%@ page import="java.time.Month" %>
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
        <img src="../../Assets/SerWise.png" class="navimg">

        <table>
            <tr>
                <td><a href="../Home/home.jsp">Home</a></td>

                <td>
                    <a href="/SerWise_war/AppoinmentController?command=LIST">Appoinments</a>
                </td>

                <td><a href="../Reports/reports.jsp">Reports</a></td>

                <td>
                    <a href="/SerWise_war/InventoryController?command=LIST">Inventory</a>
                </td>

                <td><a href="../../Login/login.html"><button class="button">Logout</button></a></td>
            </tr>
        </table>
    </header>
    
    <div class="two-content-div glass">
        <div>
            <span class="title">SerWise</span><br>
            <span>Branch manager reports page</span>
        </div>

        <div>
            <div class="colomn-content-div">
                <form action="/SerWise_war/ReportController">
                    <input type="hidden" name="command" value="CURRENT">
                    <div>
                        <span class="title">View Current Month Status</span><br>
                        <span>Make an appointment to get the best services.
                            Make an appointment to get the best services</span><br>
                        <input type="submit" class="button" value="View">
                    </div>
                </form>

                <form action="/SerWise_war/ReportController">
                    <input type="hidden" name="command" value="PREVIOUS">
                    <input type="hidden" name="search_month" value="0">
                    <div>
                        <span class="title">View Previous Reports</span><br>
                        <span>View your appointments here to keep track.
                            View your appointments here to keep track.</span><br>
                        <input type="submit" class="button" value="View">
                    </div>
                </form>
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