package com.CS01.SerWise;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class ServletReportController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        //int employee_Id=(Integer)session.getAttribute("employeeId");
        int branch_Id=(Integer) session.getAttribute("branchId");

        PrintWriter out=response.getWriter();

        String theCommand=(String) request.getParameter("command");
        out.println(theCommand);
        out.println("Nipuna Dakshina");




    }

}
