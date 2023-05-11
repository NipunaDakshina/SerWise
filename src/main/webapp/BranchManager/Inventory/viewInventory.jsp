
<%--
  Created by IntelliJ IDEA.
  User: Nipuna
  Date: 4/19/2023
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.mysql.cj.Session" %>
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
    <title>Document</title>
</head>
<body>

<header class="navigation"></header>

<div class="single-content-div center title">
    <span class="title">SerWise &MediumSpace;</span> <span class="subtitle"> - &MediumSpace; View Inventory List</span>
</div>


<div class="single-content-div center title">
    Search By Name : &MediumSpace;
    <form>
    <input type="text" id="searchInput" placeholder="item name">
    </form>

     <!--
    <form action="/SerWise_war/ServletsearchInventory">
        <input type="text" placeholder="Item Name" name="name" >
        <input type="submit" value="Search" class="button">
    </form>
    -->

</div>


<div class="form-display-table glass">
<table id="myTable">
    <tr>
        <th>Item Id</th>
        <th>Name</th>
        <th>Branch Id</th>
        <th>Batch No</th>
        <th>Quantity</th>
        <th>Handling Time</th>
    </tr>
    <tbody>
    <%
        Integer attrVal = (Integer) request.getAttribute("noOfRows");
        int noOfRows=attrVal.intValue();
        int i = 0;
        if(noOfRows !=0) {
            while (i < noOfRows) {
    %>

    <tr>
        <td><%= request.getAttribute("itemId" + i) %></td>
        <td><%= request.getAttribute("name"+i) %> </td>
        <td><%= request.getAttribute("branchId" + i) %></td>
        <td><%= request.getAttribute("batchNo" + i)%></td>
        <td><%= request.getAttribute("quantity" + i) %></td>
        <td><%= request.getAttribute("handlingTime" + i)%></td>
    </tr>

    <%
                i++;
            }
        }else{
            out.println("<tr> <td colspan=\"8\">Not Found!</td></tr>");
        }
    %>
    </tbody>
</table>
</div>

<footer class="footer">
    <div class="center"><img src="/SerWise_war/Assets/SerWise.png" class="logo"></div>
    <div class="center"><a href="#"> Contact Us </a> &nbsp|
        &nbsp<a href="#"> About Us </a> &nbsp|
        &nbsp <a href="#"> Legal Stuff </a></div>
    <div class="center">All Rights Recieved</div>
</footer>

<script src="/SerWise_war/BranchManager/BranchManagerHeader.js"></script>
<script>
    document.getElementById('searchInput').addEventListener('input', searchTable);

    function searchTable() {
        var input = document.getElementById('searchInput');
        var filter = input.value.toUpperCase();
        var table = document.getElementById('myTable');
        var rows = table.getElementsByTagName('tr');

        // Remove existing "Not Found!" row if present
        var notFoundRow = table.querySelector('.not-found-row');
        if (notFoundRow) {
            notFoundRow.remove();
        }

        // Start loop from index 1 to exclude the table header row (index 0)
        var foundMatch = false;
        for (var i = 1; i < rows.length; i++) {
            var cells = rows[i].getElementsByTagName('td');
            var shouldShowRow = false;

            // Check the second column (index 1) in each row for a match
            var cell = cells[1]; // Get the second cell (index 1)
            if (cell) {
                var cellText = cell.textContent || cell.innerText;
                if (cellText.toUpperCase().indexOf(filter) > -1) {
                    shouldShowRow = true;
                    foundMatch = true;
                }
            }

            // Show or hide the row based on the search result
            rows[i].style.display = shouldShowRow ? 'table-row' : 'none';
        }

        // If no matches found, display "Not Found!" row
        if (!foundMatch) {
            var tbody = table.querySelector('tbody');
            var notFoundRow = document.createElement('tr');
            notFoundRow.className = 'not-found-row';
            var notFoundCell = document.createElement('td');
            notFoundCell.colSpan = 6; // Set the colspan to match the number of columns
            notFoundCell.textContent = 'Not Found!';
            notFoundRow.appendChild(notFoundCell);
            tbody.appendChild(notFoundRow);
        }
    }


</script>
</body>
</html>
