package com.CS01.SerWise.Services.Job;

import com.CS01.SerWise.Controllers.*;
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
import java.util.List;

@WebServlet(name = "ServletviewCurrentJob", value = "/ServletviewCurrentJob")
public class viewCurrentJob extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get branch id and employee id from the session
        HttpSession session=request.getSession();
        int employee_Id=(Integer)session.getAttribute("employeeId");
        String branch_Id= Integer.toString((Integer) session.getAttribute("branchId"));

        PrintWriter out=response.getWriter();
        //intialize variable for job id
        String jobId = null;

        try {

            // get slot leader id form employee table
            String slotLeader_Id=null;
            ArrayList<String[]> result1= slotLeaderTable.select("Slot_Leader_Id","Employee_Id="+employee_Id);
            for(String[] i: result1) {
                out.println("Slot Leader Id="+i[0]);
                slotLeader_Id=i[0];
            }

            // get slot id form slot leader table
            String slot_Id=null;
            ArrayList<String[]> result2= slotTable.select("*","Slot_Leader_Id ="+slotLeader_Id);
            for(String[] i: result2){
                out.println("Slot Id="+i[0]);
                slot_Id=i[0];
            }


            //get ongoing job related to slot
            String where1="Branch_Id="+branch_Id+" AND Slot="+slot_Id+" AND Status='Ongoing'";
            ArrayList<String[]> result3= jobTable.select("*",where1);
            out.println(result3.size());
            int noofrows=0;

            //get ongoing job details and set to the request
            for(String[] i : result3){
                request.setAttribute("jobId"+noofrows,i[0]);
                jobId=i[0];
                out.println("Ongoing Job Id="+jobId);
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

            //set slot leader id to the request
            request.setAttribute("slotLeaderId",slotLeader_Id);

            //get job has service list
            // get service id details from job_has_services table
            String serviceId=null;
            ArrayList<String[]> result4= jobServiceTable.select("*","Job_ID="+jobId);

            //initialize array list for service list and inventory item list related to ongoing job
            List<String> serviceList = new ArrayList<>();
            List<String> inventoryItemList=new ArrayList<>();

            //get service list
            for(String[] i: result4) {
                out.println("service ID = " + i[1]);
                serviceId = i[1];
                //get service list
                String serviceName=null;
                ArrayList<String[]> result5= serviceTable.select("*","Service_Id="+serviceId);
                for(String[] j:result5){
                    serviceName=j[1];
                    out.println("Service Name="+serviceName);
                    serviceList.add(serviceName);
                }
            }

            //get inventory list
            String inventoryItemId=null;
            String inventoryItemName=null;
            //get inventory item id
            ArrayList<String[]> result6=jobInventoryItemTable.select("*","Job_ID="+jobId);
            for(String[] k: result6){
                inventoryItemId=k[1];
                out.println("Inventory Item Id="+inventoryItemId);
                //get inventory item name
                ArrayList<String[]> result7=inventoryItemTable.select("*","Inventory_Item_Id="+inventoryItemId);
                for(String[] l:result7){
                    inventoryItemName=l[1];
                    out.println("Inventory item name ="+inventoryItemName);
                    inventoryItemList.add(inventoryItemName);
                }

            }

            //set service list and inventory item list to the request
            request.setAttribute("serviceList",serviceList);
            request.setAttribute("itemList",inventoryItemList);

            //send ongoing job details to the slot leader view ongoing job page
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/SlotLeader/Jobs/currentJob.jsp");
            requestDispatcher.forward(request,response);

        } catch (Exception e) {
            //if there is an error, send it to error page
            request.setAttribute("exception",e);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error/error.jsp");
            dispatcher.forward(request, response);
        }
    }

}



