package com.CS01.SerWise;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletViewAppointments", value = "/ServletViewAppointments")
public class ServletViewAppointments extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String theCommand=request.getParameter("command");
        out.println(theCommand);


            if(theCommand ==null){
                theCommand="LIST";
            }

            if(theCommand.equals("LIST")){
                List<Appoinmtent> appoinments=new ArrayList<>();
                Connection con=null;
                Statement stmt=null;
                ResultSet rs=null;

                try{
                    con=DatabaseConnection.initializeDatabase();

                    String sql="SELECT * FROM serwise.appoinment";

                    stmt= con.createStatement();

                    rs=stmt.executeQuery(sql);


                    //HttpSession session=request.getSession();
                    //session.setAttribute("APPOINTMENTS",appoinments);
                    //response.sendRedirect("BranchManager/Appoinments/viewAppoinments.jsp");

                    request.setAttribute("rs",rs);
                    RequestDispatcher rd=request.getRequestDispatcher("BranchManager/Appoinments/viewAppoinments.jsp");
                    rd.forward(request,response);
                    //response.sendRedirect("BranchManager/Appoinments/viewAppoinments.jsp");

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } finally {
                    close(con,stmt,rs);
                }
            }
            if (theCommand.equals("UPDATE")) {
                int appointmentId=Integer.parseInt(request.getParameter("appointmentId"));
                out.println(appointmentId);
                Connection con=null;
                Statement stmt=null;
                ResultSet rs=null;
                try{
                    con=DatabaseConnection.initializeDatabase();

                    String sql="SELECT * FROM serwise.appoinment where Appoinment_Id="+appointmentId;

                    stmt= con.createStatement();

                    rs=stmt.executeQuery(sql);

                    //rs.next();
                    /*
                    int appoinmentId=rs.getInt("Appoinment_Id");
                    String date=rs.getString("Date");
                    String time=rs.getString("Time");
                    String description=rs.getString("Desription");
                    int clientId=rs.getInt("Registered_Client_Id");
                    int branchId=rs.getInt("Branch_Id");
                    int vehicleId=rs.getInt("Vehicle_Id");

                    Appoinmtent tempAppoinmtent=new Appoinmtent(appoinmentId,date,time,description,clientId,branchId,vehicleId);
                    */
                    //HttpSession session=request.getSession();
                    //session.setAttribute("TEMPAPPOINTMENT",tempAppoinmtent);
                    //response.sendRedirect("BranchManager/Appoinments/resheduleAppoinments.jsp");
                    request.setAttribute("rs",rs);
                    RequestDispatcher rd=request.getRequestDispatcher("BranchManager/Appoinments/resheduleAppoinments.jsp");
                    rd.forward(request,response);


                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } finally {
                    close(con,stmt,rs);
                }


            }

            if (theCommand.equals("RESHEDULE")) {


                int appoinmentId=Integer.parseInt(request.getParameter("appointmentId"));
                String date=request.getParameter("date");
                String time=request.getParameter("time");
                String description=request.getParameter("description");
                int clientId=Integer.parseInt(request.getParameter("clientId"));
                int branchId=Integer.parseInt(request.getParameter("branchId"));
                int vehicleId=Integer.parseInt(request.getParameter("vehicleId"));

                Appoinmtent tempAppoinmtent=new Appoinmtent(appoinmentId,date,time,description,clientId,branchId,vehicleId);
                //out.println(tempAppoinmtent.toString());
                Connection con=null;
                PreparedStatement ps=null;
                String sql=null;
                try {
                con=DatabaseConnection.initializeDatabase();
                sql="update serwise.appoinment set Date=? , Time=?, Desription=? where Appoinment_Id=?";
                ps=con.prepareStatement(sql);
                ps.setString(1,date);
                ps.setString(2,time);
                ps.setString(3,description);
                ps.setInt(4,appoinmentId);

                ps.executeUpdate();

                response.sendRedirect("BranchManager/Appoinments/appointments.jsp");

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                finally {
                    try {


                        if (con != null) {
                            con.close();
                        }
                        if (ps != null) {
                            ps.close();
                        }
                    }catch (Exception e){
                        throw  new RuntimeException(e);
                    }
                }
                }


            }

    private void close(Connection con, Statement stmt, ResultSet rs) {
       try {
           if(rs !=null){
               rs.close();
           }
           if(stmt != null){
               stmt.close();
           }
           if(con != null){
               con.close();
           }
       }
       catch (Exception exc){
           exc.printStackTrace();
       }
    }


}
