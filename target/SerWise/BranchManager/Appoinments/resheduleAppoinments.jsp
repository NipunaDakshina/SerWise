<%@ page language="java" contentType="text/html; ISO-8859-1" %>
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
                <td><a href="../../Login/login.html"><button class="button">Logout</button></a></td>
            </tr>
        </table>
    </header>



    <div>
    <form action="../../SerWise_war/ViewAppoinments" >
        <input type="hidden" name="command" value="RESHEDULE">
        <table class="form-display-table">
            <tbody>
            <%

                ResultSet rs=(ResultSet) request.getAttribute("rs");
                rs.next();
                int appoinmentId=rs.getInt("Appoinment_Id");
                String date=rs.getString("Date");
                String time=rs.getString("Time");
                String description=rs.getString("Desription");
                int clientId=rs.getInt("Registered_Client_Id");
                int branchId=rs.getInt("Branch_Id");
                int vehicleId=rs.getInt("Vehicle_Id");

                Appoinmtent tempAppointment=new Appoinmtent(appoinmentId,date,time,description,clientId,branchId,vehicleId);
                out.println("<tr>");
                    out.println("<td>Appointment Id</td>");
                    out.println("<td><label>"+ tempAppointment.getAppointmentId());
                        out.println("<input type=\"hidden\" name=\"appointmentId\" value="+tempAppointment.getAppointmentId()+">");
                    out.println("</label></td>");
                out.println("</tr>");
                out.println("<tr>");
                    out.println("<td>Date</td>");
                    out.println("<td><input type=\"date\" name=\"date\" value="+ tempAppointment.getDate()+"></td>");
                out.println("</tr>");
                out.println("<tr>");
                    out.println("<td>Time</td>");
                    out.println("<td><input type=\"time\" name=\"time\" value="+tempAppointment.getTime()+"></td>");
                out.println("</tr>");
                out.println("<tr>");
                    out.println("<td>Description</td>");
                    out.println("<td><label> "+tempAppointment.getDescription());
                    out.println("<input type=\"hidden\" name=\"description\" value="+tempAppointment.getDescription()+">");
                    out.println("</label></td>");

                out.println("</tr>");
                out.println("<tr>");
                    out.println("<td>Client Id</td>");
                    out.println("<td><label>"+tempAppointment.getClientId());
                       out.println("<input type=\"hidden\" name=\"clientId\" value="+tempAppointment.getClientId()+">");
                    out.println("</label></td>");
                out.println("</tr>");
                out.println("<tr>");
                   out.println("<td>Branch Id</td>");
                    out.println("<td><label>"+tempAppointment.getBranchId());
                        out.println("<input type=\"hidden\" name=\"branchId\" value="+tempAppointment.getBranchId()+">");
                    out.println("</label></td>");
                out.println("</tr>");
                out.println("<tr>");
                    out.println("<td>Vehicle Id</td>");
                    out.println("<td><label>"+ tempAppointment.getVehicleId());
                        out.println("<input type=\"hidden\" name=\"vehicleId\" value="+tempAppointment.getVehicleId()+">");
                    out.println("</label></td>");
                out.println("</tr>");

                out.println("<tr>");
                    out.println("<td><label></label></td>");
                     out.println("<td><input type=\"submit\" value=\"Reshedule\" class=\"button\"></td>");
                out.println("</tr>");



            %>
            </tbody>
        </table>
    </form>
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