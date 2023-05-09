package com.CS01.SerWise.Services.Report;

import com.CS01.SerWise.Controllers.jobTable;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ServletviewPreviousReport", value = "/ServletviewPreviousReport")
public class viewPreviousReport extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
       // out.println("This is previous report servelet");

        HttpSession session=request.getSession();
        //int employee_Id=(Integer)session.getAttribute("employeeId");
        String branch_Id;
        branch_Id = Integer.toString((Integer) session.getAttribute("branchId"));

        String monthYear=(String) request.getParameter("month");
        out.println("year month "+monthYear);


        request.setAttribute("branchID",branch_Id);
        request.setAttribute("month",monthYear);
        String appoinmentDone;
        String income;
        String rank;

        try {
            //get no of appoinment that is done by branch
            //<String[]> result1 = appoinmentTable.select("count(Appoinment_Id)","Date Like '"+monthYear+"%'");
            ArrayList<String[]> result1= jobTable.select("count(Job_ID)","Branch_Id="+branch_Id+" and (Status='Done' or Status='Billed')  and Date Like '"+monthYear+"%' ");
            for (String [] i:result1){
                appoinmentDone=i[0];
                //out.println("No of Appoinment :"+appoinmentDone);
                request.setAttribute("doneApp",appoinmentDone);
            }



            //get total income of selected month

            ArrayList<String[]> result3=jobTable.select("SUM(Total)","Branch_Id="+branch_Id+" and Status='Billed' and Date Like '"+monthYear+"%'");
            for(String[] k:result3){
                income=k[0];
                //out.println("Total Income : "+income);
                request.setAttribute("income",income);
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/BranchManager/Report/previousMonth.jsp");
            requestDispatcher.forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
