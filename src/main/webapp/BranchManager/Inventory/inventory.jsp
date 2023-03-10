<%@ page import="java.util.List" %>
<%@ page import="com.CS01.SerWise.Inventory" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/SerWise_war/CSS/content.css">
    <link rel="stylesheet" href="/SerWise_war/CSS/navigation.css">
    <link rel="stylesheet" href="/SerWise_war/CSS/footer.css">
    <link rel="stylesheet" href="/SerWise_war/CSS/background.css">
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

                <td><a href="/SerWise_war/Login/login.html"><button class="button">Logout</button></a></td>
            </tr>
        </table>
    </header>


    <div class="single-content-div center title">
        <span class="title">SerWice &MediumSpace;</span> <span class="subtitle"> - &MediumSpace; Manage Inventory Items</span>
    </div>


    <div class="single-content-div center title">
        Search By Name : &MediumSpace;
        <form action="/SerWise_war/InventoryController">
            <input type="hidden" name="command" value="SEARCH">
            <input type="text" placeholder="Item Name" name="item_name">&MediumSpace;
            <input type="submit" value="Search" class="button">
        </form>
    </div>

    <div class="form-display-table glass ">
        <table>
            <tr>
                <th>Item ID</th>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Description</th>
                <th>Handling Time</th>
            </tr>
            <tbody>
                <%
                    List<Inventory> inventory=new ArrayList<>();
                    inventory=(List<Inventory>) request.getAttribute("INVENTORY");
                    if (inventory.isEmpty()){
                %>
                    <tr>
                        <td colspan="5">Nothing to show</td>
                    </tr>
                <%
                    }
                %>

                <%
                    if(!inventory.isEmpty()){
                        for(Inventory theInventory:inventory){
                            int itemId= theInventory.getItemId();
                            String itemName= theInventory.getItemName();
                            String handlingTime=theInventory.getHandlingDate();
                            float quantity=theInventory.getQuantity();
                            String description=theInventory.getDescription();
                %>

                <tr>
                    <td><%=itemId%></td>
                    <td><%=itemName%></td>
                    <td><%=quantity%></td>
                    <td><%=description%></td>
                    <td><%=handlingTime%></td>
                </tr>

                <%  }
                } %>
            </tbody>
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