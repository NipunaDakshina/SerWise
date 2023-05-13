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
import java.util.ArrayList;

@WebServlet(name = "ServletlistAppoinment", value = "/ServletlistAppoinment")
public class listAppoinment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get branch Id and employee Id related to branch manager from session
        HttpSession session=request.getSession();
        int employee_Id=(Integer)session.getAttribute("employeeId");
        String branch_Id = Integer.toString((Integer) session.getAttribute("branchId"));

        PrintWriter out=response.getWriter();

        try {
            //get appoinment list related to the branch from controller
            ArrayList<String[]> results = appoinmentTable.select("*","Branch_Id="+branch_Id);
            int noofrows = 0;

            //assing each appoinment details to the request
            for (String[] i : results){
                request.setAttribute("appoinmentId"+noofrows,i[0]);
                request.setAttribute("date"+noofrows,i[1]);
                request.setAttribute("time"+noofrows,i[2]);
                request.setAttribute("desription"+noofrows,i[3]);
                request.setAttribute("clientId"+noofrows,i[4]);
                request.setAttribute("branchId"+noofrows,i[5]);
                request.setAttribute("vehicleId"+noofrows,i[6]);
                noofrows+=1;//increament appoinment count
            }
            //set appoinment count to the request
            request.setAttribute("noOfRows",noofrows);

            //redirect to the branch manager view appoinment page
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/BranchManager/Appoinment/viewAppoinment.jsp");
            requestDispatcher.forward(request,response);

        } catch (Exception e) {
            //if there is an error during above task redirect to the error page
            request.setAttribute("exception",e);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error/error.jsp");
            dispatcher.forward(request, response);
        }
    }

}
