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
import java.time.YearMonth;
import java.util.ArrayList;

@WebServlet(name = "ServletviewCurrentMonthReport", value = "/ServletviewCurrentMonthReport")
public class viewCurrentMonthReport extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();

        //get branch id and employee id from the session
        HttpSession session=request.getSession();
        int employee_Id=(Integer)session.getAttribute("employeeId");
        String branch_Id= Integer.toString((Integer) session.getAttribute("branchId"));

        //get current month --> format 2023-04
        YearMonth yearMonth = YearMonth.now();
        String monthYear = yearMonth.toString();
        out.println("Month year"+monthYear);

        //set current month to the request
        String month=(String) request.getParameter("month");
        out.println("Month"+month);

        //set current month with year to the request
        request.setAttribute("branchID",branch_Id);
        request.setAttribute("month",monthYear);

        // intialize variable for no of ongoing and done appoinment
        String appoinmentDone;
        String appoinmentOngoing;

        //intialize variable for total income for selected month
        String income;
        String rank;

        try {
            //get no of appoinment that is done by branch
            ArrayList<String[]> result1= jobTable.select("count(Job_ID)","Branch_Id="+branch_Id+" and Status='Done' and Date Like '"+monthYear+"%' ");
            for (String [] i:result1){
                appoinmentDone=i[0];
                //set no of done appoinment
                request.setAttribute("doneApp",appoinmentDone);
            }

            //get ongoing appoinment that is doing by branch
            ArrayList<String[]> result2= jobTable.select("count(Job_ID)","Branch_Id="+branch_Id+" and Status='Ongoing' and Date Like '"+monthYear+"%' ");
            for(String [] j:result2){
                appoinmentOngoing=j[0];
                //set no of ongoing appoinment
                request.setAttribute("ongoingApp",appoinmentOngoing);
            }

            //get total income of selected month
            ArrayList<String[]> result3=jobTable.select("SUM(Total)","Branch_Id="+branch_Id+" and Status='Billed' and Date Like '"+monthYear+"%'");
            for(String[] k:result3){
                income=k[0];
                //set total income for current month
                request.setAttribute("income",income);
            }

            //redirect to the branch manger report view page
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/BranchManager/Report/viewReport.jsp");
            requestDispatcher.forward(request,response);
        } catch (Exception e) {
            //if there is an error, redirect to the error page
            request.setAttribute("exception",e);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error/error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
