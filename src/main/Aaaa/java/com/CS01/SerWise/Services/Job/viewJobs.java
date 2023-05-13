package com.CS01.SerWise.Services.Job;

import com.CS01.SerWise.Controllers.jobTable;
import com.CS01.SerWise.Controllers.slotLeaderTable;
import com.CS01.SerWise.Controllers.slotTable;
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

@WebServlet(name = "ServletlistJobs", value = "/ServletlistJobs")
public class viewJobs extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get employee id and branch id details from session
        HttpSession session=request.getSession();
        int employee_Id=(Integer)session.getAttribute("employeeId");
        String branch_Id= Integer.toString((Integer) session.getAttribute("branchId"));

        PrintWriter out=response.getWriter();

        String slot_Id=null;
        String slotLeader_Id=null;

        try {

            // get slot leader id from employee id
            ArrayList<String[]> result1= slotLeaderTable.select("Slot_Leader_Id","Employee_Id="+employee_Id);
            for(String[] i: result1) {
                out.println(i[0]);
                slotLeader_Id=i[0];
            }


            // get slot id from slot leader id
            ArrayList<String[]> result2= slotTable.select("*","Slot_Leader_Id ="+slotLeader_Id);
            for(String[] i: result2){
                out.println(i[0]);
                slot_Id=i[0];
            }

            //get all the jobs related to the slot id
            String where="Branch_ID="+branch_Id+" and Slot="+slot_Id;
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
                //increase no of jobs
                noofrows+=1;
            }

            //set no of jobs to the request
            request.setAttribute("noOfRows",noofrows);

            //redirect to the slot leader view jobs page
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/SlotLeader/Jobs/viewJobs.jsp");
            requestDispatcher.forward(request,response);
        }catch (Exception e) {
            // if there is an error, redirect to the error page
            request.setAttribute("exception",e);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error/error.jsp");
            dispatcher.forward(request, response);
        }
    }

}


