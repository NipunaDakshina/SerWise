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

@WebServlet(name = "ServletremoveAppoinment", value = "/ServletremoveAppoinment")
public class removeAppoinment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get branch id from session
        HttpSession session=request.getSession();
        int employee_Id=(Integer)session.getAttribute("employeeId");
        String branch_Id = Integer.toString((Integer) session.getAttribute("branchId"));

        //get appoinment id  to be deleted
        String id=request.getParameter("id");
        PrintWriter out=response.getWriter();

        try {
            //delete the appoinment related to the appoinment id
            appoinmentTable.delete(id);

            //redirect to the branch manager view appoinment page
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ServletlistAppoinment");
            requestDispatcher.forward(request,response);
        }catch (Exception e) {
            //if error occur, redirect to the error page
            request.setAttribute("exception",e);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error/error.jsp");
            dispatcher.forward(request, response);
        }

    }

}
