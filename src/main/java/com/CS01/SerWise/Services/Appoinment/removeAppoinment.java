package com.CS01.SerWise.Services.Appoinment;

import com.CS01.SerWise.Controllers.appoinmentTable;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "ServletremoveAppoinment", value = "/ServletremoveAppoinment")
public class removeAppoinment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        //int employee_Id=(Integer)session.getAttribute("employeeId");
        String branch_Id;
        branch_Id = Integer.toString((Integer) session.getAttribute("branchId"));
        String id=request.getParameter("id");
        PrintWriter out=response.getWriter();
        out.println(id);
        try {
            appoinmentTable.delete(id);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ServletlistAppoinment");
            requestDispatcher.forward(request,response);
        }catch (Exception e) {
            request.setAttribute("exception",e);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error/error.jsp");
            dispatcher.forward(request, response);
        }

    }

}
