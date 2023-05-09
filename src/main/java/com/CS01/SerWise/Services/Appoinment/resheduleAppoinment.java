package com.CS01.SerWise.Services.Appoinment;

import com.CS01.SerWise.Controllers.appoinmentTable;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "ServletresheduleAppoinment", value = "/ServletresheduleAppoinment")
public class resheduleAppoinment extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        //int employee_Id=(Integer)session.getAttribute("employeeId");
        String branch_Id;
        branch_Id = Integer.toString((Integer) session.getAttribute("branchId"));
        //String command = request.getParameter("command");
        String date="";
        String time="";
        String id=request.getParameter("id");
        String old_date=request.getParameter("old_date");
        String old_time=request.getParameter("old_time");
        String new_date=request.getParameter("new_date");
        String new_time=request.getParameter("new_time");
        PrintWriter out=response.getWriter();
//        out.println(id);
//        out.println(new_date);
//        out.println(new_time);
        if(new_date=="" && new_time!=""){
            date=old_date;
            time=new_time;
        }
        date=new_date;
        time=new_time;
        String afterSet = "Date='%s',Time='%s'";
        String afterWhere = "Appoinment_Id='%s' and Branch_Id='%s'";
        afterSet = String.format(afterSet,date,time);
        afterWhere = String.format(afterWhere,id,branch_Id);
        try {
            appoinmentTable.update(afterSet,afterWhere);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ServletlistAppoinment");
            requestDispatcher.forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
