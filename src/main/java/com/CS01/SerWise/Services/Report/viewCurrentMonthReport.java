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
import java.sql.SQLException;
import java.time.YearMonth;
import java.util.ArrayList;

@WebServlet(name = "ServletviewCurrentMonthReport", value = "/ServletviewCurrentMonthReport")
public class viewCurrentMonthReport extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        out.println("This is currnet moonth report servlet");

        HttpSession session=request.getSession();
        //int employee_Id=(Integer)session.getAttribute("employeeId");
        String branch_Id;
        branch_Id = Integer.toString((Integer) session.getAttribute("branchId"));

        YearMonth yearMonth = YearMonth.now();
        String monthYear = yearMonth.toString();
        out.println("Month year"+monthYear);

        String month=(String) request.getParameter("month");
        out.println("Month"+month);

        request.setAttribute("branchID",branch_Id);
        request.setAttribute("month",monthYear);
        String appoinmentDone;
        String appoinmentOngoing;
        String income;
        String rank;

        try {
            //get no of appoinment that is done by branch
            //<String[]> result1 = appoinmentTable.select("count(Appoinment_Id)","Date Like '"+monthYear+"%'");
            ArrayList<String[]> result1= jobTable.select("count(Job_ID)","Branch_Id="+branch_Id+" and Status='Done' and Date Like '"+monthYear+"%' ");
            for (String [] i:result1){
                appoinmentDone=i[0];
                //out.println("No of Appoinment :"+appoinmentDone);
                request.setAttribute("doneApp",appoinmentDone);
            }

            //get ongoing appoinment that is doing by branch
            ArrayList<String[]> result2= jobTable.select("count(Job_ID)","Branch_Id="+branch_Id+" and Status='Ongoing' and Date Like '"+monthYear+"%' ");
            for(String [] j:result2){
                appoinmentOngoing=j[0];
                //out.println("Ongoing Appoinment : "+appoinmentOngoing);
                request.setAttribute("ongoingApp",appoinmentOngoing);
            }

            //get total income of selected month
            ArrayList<String[]> result3=jobTable.select("SUM(Total)","Branch_Id="+branch_Id+" and Status='Billed' and Date Like '"+monthYear+"%'");
            for(String[] k:result3){
                income=k[0];
                //out.println("Total Income : "+income);
                request.setAttribute("income",income);
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/BranchManager/Report/currentMonth.jsp");
            requestDispatcher.forward(request,response);
        } catch (Exception e) {
            request.setAttribute("exception",e);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error/error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
