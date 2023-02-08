package com.CS01.SerWise;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletJobs", value = "/ServletJobs")
public class ServletJobs extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //this section is used for defining session store for slot leader details
        HttpSession session=request.getSession();
        int employee_Id=(Integer)session.getAttribute("employeeId");
        int branch_Id=(Integer) session.getAttribute("branchId");
        PrintWriter out=response.getWriter();
        String theCommand =(String) request.getParameter("command");

        if(theCommand.equals("VIEWJOBS")){
            List<Job> jobs=new ArrayList<>();
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
                    Job tempJob=new Job(appoinmentId,date,time);
                    jobs.add(tempJob);
                    //out.println(tempJob.toString());
                }
                //this is for testing the job view page
                Job testJOb=new Job(335577,"2023-02-07","9:45 a.m.");
                jobs.add(testJOb);

                request.setAttribute("JOBS",jobs);
                RequestDispatcher rd=request.getRequestDispatcher("SlotLeader/Jobs/viewJobs.jsp");
                rd.forward(request,response);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } finally {
                close(connection,statement,resultSet);
            }



        }


        if(theCommand.equals("VIEWCURRENTJOB")){
            Connection connection=null;
            Statement statement=null;
            ResultSet resultSet=null;
            try {
                connection = DatabaseConnection.initializeDatabase();
                String sql = "select * from serwise.appoinment " +
                        "where hour(appoinment.time) between hour(current_time()) and hour(current_time())+1 limit 1; ";
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);
                resultSet.next();
                    int appoinmentId=resultSet.getInt("Appoinment_Id");
                    String date=resultSet.getString("Date");
                    String time=resultSet.getString("Time");
                    Job tempJob=new Job(appoinmentId,date,time);
                    //out.println(tempJob.toString());

                //this is for testing the job view page
                Job testJOb=new Job(335577,"2023-02-07","9:45 a.m.");

                request.setAttribute("CURRENTJOB",testJOb);
                RequestDispatcher rd=request.getRequestDispatcher("SlotLeader/CurrentJob/viewCurrentJob.jsp");
                rd.forward(request,response);


            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } finally {
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
