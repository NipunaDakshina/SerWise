package com.CS01.SerWise.Services.Appoinment;

import com.CS01.SerWise.Controllers.appoinmentTable;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletresheduleAppoinment", value = "/ServletresheduleAppoinment")
public class resheduleAppoinment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get branch id and employee id from the session
        HttpSession session=request.getSession();
        int employee_Id=(Integer)session.getAttribute("employeeId");
        String branch_Id=Integer.toString((Integer) session.getAttribute("branchId"));


        String date="";
        String time="";
        //get current appoinment date,time and appoinemet id with their changed values from request
        String id=request.getParameter("id");
        String old_date=request.getParameter("old_date");
        String old_time=request.getParameter("old_time");
        String new_date=request.getParameter("new_date");
        String new_time=request.getParameter("new_time");
        PrintWriter out=response.getWriter();


        if(new_date=="" && new_time!=""){
            date=old_date;
            time=new_time;
        }
        //set updated values for date, and time
        date=new_date;
        time=new_time;
        String afterSet = "Date='%s',Time='%s'";
        String afterWhere = "Appoinment_Id='%s' and Branch_Id='%s'";
        afterSet = String.format(afterSet,date,time);
        afterWhere = String.format(afterWhere,id,branch_Id);
        try {
            //reshedule appoinment with user entered date and time
            appoinmentTable.update(afterSet,afterWhere);

            //redirect to the branch manager view appoinment page
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ServletlistAppoinment");
            requestDispatcher.forward(request,response);
        } catch (Exception e) {
            //if errors occur , redirect to the error page
            request.setAttribute("exception",e);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error/error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
