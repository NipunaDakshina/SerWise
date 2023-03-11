package com.CS01.SerWise;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class ServletReportController extends HttpServlet {

    private ReportDBUtill reportDBUtill;

    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        // create our student db util ... and pass in the conn pool / datasource
        try {
            reportDBUtill = new ReportDBUtill(dataSource);
        }
        catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        //int employee_Id=(Integer)session.getAttribute("employeeId");
        int branch_Id=(Integer) session.getAttribute("branchId");

        PrintWriter out=response.getWriter();

        String theCommand=(String) request.getParameter("command");
        //out.println(theCommand);
        //out.println("Nipuna Dakshina");

        if(theCommand.equals("CURRENT")){
            listReport(request,response);


        } else if (theCommand.equals("PREVIOUS")) {
            listReport(request,response);
        }


    }

    private void listReport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        //int employee_Id=(Integer)session.getAttribute("employeeId");
        int branch_Id=(Integer) session.getAttribute("branchId");

        LocalDate date = LocalDate.now(); // get the current date
        Month month = date.getMonth(); // get the current month
        int currentMonth = month.getValue(); // get the current month value (1-12)
        int currentYear = Year.now().getValue();

        List<Report> reports=new ArrayList<>();

        String theCommand=(String) request.getParameter("command");
        int search_month=Integer.parseInt((String) request.getParameter("search_month"));
        int search_year=Integer.parseInt((String) request.getParameter("search_year"));

        if(theCommand.equals("CURRENT")){
            reports=ReportDBUtill.getReport(branch_Id,currentYear,currentMonth);

            request.setAttribute("REPORT",reports);
            RequestDispatcher rd=request.getRequestDispatcher("BranchManager/Repots/currentStatus.jsp");
            rd.forward(request,response);
        }
        else if (theCommand.equals("PREVIOUS") && search_month==0){
            reports=ReportDBUtill.getReport(branch_Id,currentYear,currentMonth);

            request.setAttribute("REPORT",reports);
            RequestDispatcher rd=request.getRequestDispatcher("BranchManager/Repots/previousStatus.jsp");
            rd.forward(request,response);
        }
        else if (theCommand.equals("FINDPREVIOUS")){
            reports=ReportDBUtill.getReport(branch_Id,search_year,search_month);

            request.setAttribute("REPORT",reports);
            RequestDispatcher rd=request.getRequestDispatcher("BranchManager/Repots/previousStatus.jsp");
            rd.forward(request,response);
        }










    }

}
