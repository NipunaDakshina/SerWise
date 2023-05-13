package com.CS01.SerWise.Services.Report;

import com.CS01.SerWise.Controllers.jobTable;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "ServletviewPreviousReport", value = "/ServletviewPreviousReport")
public class viewPreviousReport extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();

        //get branch id and employee id from the session
        HttpSession session=request.getSession();
        int employee_Id=(Integer)session.getAttribute("employeeId");
        String branch_Id= Integer.toString((Integer) session.getAttribute("branchId"));

        //get the month details from the request ---> format 2023-03
        String monthYear=(String) request.getParameter("month");
        out.println("year month "+monthYear);

        //set branch id and month details to  the request
        request.setAttribute("branchID",branch_Id);
        request.setAttribute("month",monthYear);

        //intialize variable for done appoinment, ongoing appoinment and income
        String appoinmentDone;
        String appoinmentOngoing=null;//set to null because there is no ongoing appoinment for previous appoinment
        String income;
        String rank;

        try {
            //get no of appoinment that is done by branch
            ArrayList<String[]> result1= jobTable.select("count(Job_ID)","Branch_Id="+branch_Id+" and (Status='Done' or Status='Billed')  and Date Like '"+monthYear+"%' ");
            for (String [] i:result1){
                appoinmentDone=i[0];
                //set no of done appoinment to the request
                request.setAttribute("doneApp",appoinmentDone);
            }



            //get total income of selected month
            ArrayList<String[]> result3=jobTable.select("SUM(Total)","Branch_Id="+branch_Id+" and Status='Billed' and Date Like '"+monthYear+"%'");
            for(String[] k:result3){
                income=k[0];
                //get total income for selected month
                request.setAttribute("income",income);
            }

            //set ongoing appoinment to request, and ongoing appoinment is already null
            request.setAttribute("ongoingApp",appoinmentOngoing);

            //redirect to the branch manager view report page
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/BranchManager/Report/viewReport.jsp");
            requestDispatcher.forward(request,response);
        } catch (Exception e) {
            //if there is an error, redirect to the error page
            request.setAttribute("exception",e);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error/error.jsp");
            dispatcher.forward(request ,response);
        }
    }
}
