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


    <div class="single-content-div center title">
        <span class="title">SerWice &MediumSpace;</span> <span class="subtitle"> - &MediumSpace; Manage Inventory Items</span>
    </div>


    <div class="single-content-div center title">
        Search By Name : &MediumSpace;
        <form>
            <input type="text" placeholder="Item Name">
            &MediumSpace;
            <input type="submit" value="Search" class="button">
        </form>
    </div>

    <div class="form-display-table glass">
        <table>
            <tr>
                <th>Item ID</th>
                <th>Item Name</th>
                <th>Measurement</th>
                <th>Reordering Level</th>
                <th>Price</th>
                <th colspan="2">Manage Options</th>
            </tr>

                       <tr>
                            <td>001</td>
                            <td>Plugs</td>
                           <td>2</td>
                           <td>5</td>
                           <td>Rs. 700.00</td>
                           <td><button class="button">Update</button></td>
                           <td><button class="button">Remove</button></td>
                       </tr>

                        <tr>
                            <td>002</td>
                            <td>Cylinder</td>
                            <td>3</td>
                            <td>7</td>
                            <td>Rs. 2900.00</td>
                            <td><button class="button">Update</button></td>
                            <td><button class="button">Remove</button></td>
                        </tr>
        </table>
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