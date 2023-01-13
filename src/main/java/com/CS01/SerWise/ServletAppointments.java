package com.CS01.SerWise;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletViewAppointments", value = "/ServletViewAppointments")
public class ServletAppointments extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //this section is used for defining session store for banch manager details
        HttpSession session=request.getSession();
        int employee_Id=(Integer)session.getAttribute("employeeId");
        int branch_Id=(Integer) session.getAttribute("branchId");
        PrintWriter out=response.getWriter();
        String theCommand =(String) request.getParameter("command");
        //out.println(theCommand);
        //out.println(employeeId);
        //out.println(branchId);


        if(theCommand.equals("LIST")){
            List<Appoinmtent> appoinmtents=new ArrayList<>();
            Connection connection=null;
            Statement statement=null;
            ResultSet resultSet=null;
            try {
                connection = DatabaseConnection.initializeDatabase();
                String sql = "SELECT * FROM serwise.appoinment where Branch_Id='" + branch_Id + "'";
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()){
                    int appoinmentId=resultSet.getInt("Appoinment_Id");
                    String date=resultSet.getString("Date");
                    String time=resultSet.getString("Time");
                    String description=resultSet.getString("Desription");
                    int clientId=resultSet.getInt("Registered_Client_Id");
                    int branchId=resultSet.getInt("Branch_Id");
                    int vehicleId=resultSet.getInt("Vehicle_Id");
                    Appoinmtent tempAppoinmtent=new Appoinmtent(appoinmentId,date,time,description,clientId,branchId,vehicleId);
                    appoinmtents.add(tempAppoinmtent);
                }

                request.setAttribute("APPOINMENTS",appoinmtents);
                RequestDispatcher rd=request.getRequestDispatcher("BranchManager/Appoinments/viewAppoinments.jsp");
                rd.forward(request,response);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } finally {
                close(connection,statement,resultSet);
            }

        }

        else if(theCommand.equals("UPDATE")){
            List<Appoinmtent> appoinmtents=new ArrayList<>();
            Connection connection=null;
            Statement statement=null;
            ResultSet resultSet=null;
            try {
                connection = DatabaseConnection.initializeDatabase();
                String sql = "SELECT * FROM serwise.appoinment where Branch_Id='" + branch_Id + "'";
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()){
                    int appoinmentId=resultSet.getInt("Appoinment_Id");
                    String date=resultSet.getString("Date");
                    String time=resultSet.getString("Time");
                    String description=resultSet.getString("Desription");
                    int clientId=resultSet.getInt("Registered_Client_Id");
                    int branchId=resultSet.getInt("Branch_Id");
                    int vehicleId=resultSet.getInt("Vehicle_Id");
                    Appoinmtent tempAppoinmtent=new Appoinmtent(appoinmentId,date,time,description,clientId,branchId,vehicleId);
                    appoinmtents.add(tempAppoinmtent);
                }

                request.setAttribute("APPOINMENTS",appoinmtents);
                RequestDispatcher rd=request.getRequestDispatcher("BranchManager/Appoinments/resheduleAppoinments.jsp");
                rd.forward(request,response);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } finally {
                close(connection,statement,resultSet);
            }



        }

        String filterDate=null;
        filterDate=request.getParameter("DATE");
        String Id=null;
        Id=request.getParameter("ID");
        int filterId=0;
        if(Id==""){
            filterId=0;
        }
        else{
            filterId=Integer.parseInt(Id);
        }

        if(theCommand.equals("SEARCH")){
            List<Appoinmtent> appoinmtents=new ArrayList<>();
            Connection connection=null;
            Statement statement=null;
            ResultSet resultSet=null;
            String sql=null;
            //out.println(theCommand);
            //out.println(filterId);
            //out.println(filterDate);
            try {
                connection = DatabaseConnection.initializeDatabase();


                if (filterDate !="" && filterId ==0) {
                    sql = "SELECT * FROM serwise.appoinment where Branch_Id='" + branch_Id + "' AND Date='"+filterDate+"';";
                }
                else if (filterDate =="" && filterId !=0) {
                    sql = "SELECT * FROM serwise.appoinment where Branch_Id='" + branch_Id + "' AND Appoinment_Id="+filterId+";";
                }
                else if (filterDate != "" && filterId !=0) {
                    sql = "SELECT * FROM serwise.appoinment where Branch_Id='" + branch_Id + "' AND Date='"+filterDate+"' AND Appoinment_Id="+filterId+";";
                }
                else{
                    sql = "SELECT * FROM serwise.appoinment where Branch_Id='" + branch_Id + "'";
                }
                out.println(sql);
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()){
                    int appoinmentId=resultSet.getInt("Appoinment_Id");
                    String date=resultSet.getString("Date");
                    String time=resultSet.getString("Time");
                    String description=resultSet.getString("Desription");
                    int clientId=resultSet.getInt("Registered_Client_Id");
                    int branchId=resultSet.getInt("Branch_Id");
                    int vehicleId=resultSet.getInt("Vehicle_Id");
                    Appoinmtent tempAppoinmtent=new Appoinmtent(appoinmentId,date,time,description,clientId,branchId,vehicleId);
                    appoinmtents.add(tempAppoinmtent);
                    //out.println(tempAppoinmtent);
                }

                request.setAttribute("APPOINMENTS",appoinmtents);
                RequestDispatcher rd=request.getRequestDispatcher("BranchManager/Appoinments/resheduleAppoinments.jsp");
                rd.forward(request,response);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            finally {
                close(connection,statement,resultSet);
            }
        }




    }

    private void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if(resultSet !=null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        catch (Exception exc){
            exc.printStackTrace();
        }
    }
}

