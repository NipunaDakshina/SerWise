package com.CS01.SerWise.Services.Job;

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

@WebServlet(name = "ServletlistallJobs", value = "/ServletlistallJobs")
public class viewAllJobs extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get branch id and employee id related to brnach manager
        HttpSession session=request.getSession();
        int employee_Id=(Integer)session.getAttribute("employeeId");
        String branch_Id= Integer.toString((Integer) session.getAttribute("branchId"));
        PrintWriter out=response.getWriter();

        try {

            //get all the jobs related to the branch
            String where="Branch_ID="+branch_Id;
            ArrayList<String[]> result3= jobTable.select("*",where);
            int noofrows = 0;
            for (String[] i : result3){
                request.setAttribute("jobId"+noofrows,i[0]);
                request.setAttribute("branchId"+noofrows,i[1]);
                request.setAttribute("date"+noofrows,i[2]);
                request.setAttribute("time"+noofrows,i[3]);
                request.setAttribute("slot"+noofrows,i[4]);
                request.setAttribute("status"+noofrows,i[5]);
                request.setAttribute("total"+noofrows,i[6]);
                request.setAttribute("vehicleId"+noofrows,i[7]);
                //increase job count
                noofrows+=1;
            }
            //set the job count to the request
            request.setAttribute("noOfRows",noofrows);

            //redirect to the branch manager view all jobs page
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/BranchManager/Jobs/viewJobs.jsp");
            requestDispatcher.forward(request,response);
        } catch (Exception e) {

            //if there is an error, redirect to the error page
            request.setAttribute("exception",e);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error/error.jsp");
            dispatcher.forward(request, response);
        }
    }

}


