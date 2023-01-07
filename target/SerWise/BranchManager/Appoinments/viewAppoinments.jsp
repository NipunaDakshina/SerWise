<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<%@ page import="java.util.*,com.CS01.SerWise.*" %>
<%@ page import="com.CS01.SerWise.Appoinmtent" %>
<%@ page import="java.sql.ResultSet" %>
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
    <header class="navigation">
        <img src="/SerWise_war/Assets/SerWise.png" class="navimg">
        <table>
            <tr>
                <td><a href="/SerWise_war/BranchManager/Home/home.html ">Home</a></td>
                <td><a href="/SerWise_war/BranchManager/Appoinments/appointments.jsp">Appointments</a></td>
                <td><a href="/SerWise_war/BranchManager/Reports/reports.html">Reports</a></td>
                <td><a href="/SerWise_war/BranchManager/Inventory/inventory.html">Inventory</a></td>
                <td><a href="../Login/login.html"><button class="button">Logout</button></a></td>
            </tr>
        </table>
    </header>
    <div class="two-content-div">
        <div class="form-display-table">
        <table>
            <tr>
                <th>Appointment Id</th>
                <th>Date</th>
                <th>Time</th>
                <th>Description</th>
                <th>Client Id</th>
                <th>Branch Id</th>
                <th>Vehicle Id</th>
                <th>Action</th>
            </tr>
            <tbody>
              <%
                  ResultSet rs=(ResultSet) request.getAttribute("rs");
                  List<Appoinmtent> appoinmtents=new ArrayList<>();
                  while(rs.next()) {
                      int appoinmentId = rs.getInt("Appoinment_Id");
                      String date = rs.getString("Date");
                      String time = rs.getString("Time");
                      String description = rs.getString("Desription");
                      int clientId = rs.getInt("Registered_Client_Id");
                      int branchId = rs.getInt("Branch_Id");
                      int vehicleId = rs.getInt("Vehicle_Id");

                      Appoinmtent theAppoinmtent = new Appoinmtent(appoinmentId, date, time, description, clientId, branchId, vehicleId);
                      //out.println(theAppoinmtent.toString());
                      appoinmtents.add(theAppoinmtent);
                      out.println("<tr>");
                      out.println("<td>");
                      out.println(theAppoinmtent.getAppointmentId());
                      out.println("</td>");
                      out.println("<td>");
                      out.println(theAppoinmtent.getDate());
                      out.println("</td>");
                      out.println("<td>");
                      out.println(theAppoinmtent.getTime());
                      out.println("</td>");
                      out.println("<td>");
                      out.println(theAppoinmtent.getDescription());
                      out.println("</td>");
                      out.println("<td>");
                      out.println(theAppoinmtent.getClientId());
                      out.println("</td>");
                      out.println("<td>");
                      out.println(theAppoinmtent.getBranchId());
                      out.println("</td>");
                      out.println("<td>");
                      out.println(theAppoinmtent.getVehicleId());
                      out.println("</td>");
                      out.println("<td>");

                      out.println(" <form action=\"../../SerWise_war/ServletViewAppointments\"  >\n" +
                              "                            <input type=\"hidden\" name=\"command\" value=\"UPDATE\">");

                      out.println("<input type=\"hidden\" name=\"appointmentId\" value="+theAppoinmtent.getAppointmentId()+">");

                     out.println("<input type=\"submit\" value=\"Reshedule\" onclick=\"if(!(confirm('Are you sure you want to update this Appoinmetnt ?'))) return false\" class=\"button\">");

                      out.println("</td>");
                      out.println("</tr>");

                  }
              %>

            </tbody>
        </table>
        </div>
    </div>
    <footer class="footer">
        <div class="center"><img src="/SerWise_war/Assets/SerWise.png" class="logo"></div>
        <div class="center"><a href="#"> Contact Us </a> &nbsp| 
            &nbsp<a href="#"> About Us </a> &nbsp|
            &nbsp <a href="#"> Legal Stuff </a></div>
        <div class="center">All Rights Recieved</div>
    </footer>
</body>
</html>