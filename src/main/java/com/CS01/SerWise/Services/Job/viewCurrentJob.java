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
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ServletviewCurrentJob", value = "/ServletviewCurrentJob")
public class viewCurrentJob extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();
        int employee_Id=(Integer)session.getAttribute("employeeId");
        String branch_Id;
        branch_Id = Integer.toString((Integer) session.getAttribute("branchId"));
        PrintWriter out=response.getWriter();

        try {

            // get slot leader id

            String slotLeader_Id=null;
            ArrayList<String[]> result1= slotLeaderTable.select("Slot_Leader_Id","Employee_Id="+employee_Id);
            for(String[] i: result1) {
                out.println(i[0]);
                slotLeader_Id=i[0];
            }

            // get slot id

            String slot_Id=null;
            ArrayList<String[]> result2= slotTable.select("*","Slot_Leader_Id ="+slotLeader_Id);
            for(String[] i: result2){
                out.println(i[0]);
                slot_Id=i[0];
            }


            //get ongoing job

            String where1="Branch_Id="+branch_Id+" AND Slot="+slot_Id+" AND Status='Ongoing'";
            ArrayList<String[]> result3= jobTable.select("*",where1);
            int noofrows=0;
            for(String[] i : result3){
                request.setAttribute("jobId"+noofrows,i[0]);
                request.setAttribute("branchId"+noofrows,i[1]);
                request.setAttribute("date"+noofrows,i[2]);
                request.setAttribute("time"+noofrows,i[3]);
                request.setAttribute("slot"+noofrows,i[4]);
                request.setAttribute("status"+noofrows,i[5]);
                request.setAttribute("total"+noofrows,i[6]);
                request.setAttribute("vehicleId"+noofrows,i[7]);
                noofrows+=1;
            }
            request.setAttribute("noOfRows",noofrows);
            //out.println("No of rows ="+noofrows);
            request.setAttribute("slotLeaderId",slotLeader_Id);

            //send ongoing job to jsp
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/SlotLeader/Jobs/currentJob.jsp");
            requestDispatcher.forward(request,response);

        } catch (Exception e) {
            request.setAttribute("exception",e);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error/error.jsp");
            dispatcher.forward(request, response);
        }
    }

}



