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

@WebServlet(name = "ServletComfirmJob", value = "/ServletComfirmJob")
public class ComfirmJob extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get branch id and employee id from the session
        HttpSession session=request.getSession();
        int employee_Id=(Integer)session.getAttribute("employeeId");
        String branch_Id= Integer.toString((Integer) session.getAttribute("branchId"));
        PrintWriter out=response.getWriter();

        //get ongoing job details from the request
        String jobId=(String)request.getParameter("jobId");
        String slot=(String)request.getParameter("slot");
        String slotLeaderId=(String)request.getParameter("slotLeaderId");
        String vehicleId=(String)request.getParameter("vehicleId");
        String date=(String)request.getParameter("date");
        String clientId = null;

        try {
            //change ongoing state to done state in job table
            String afterSet1 = "Status='%s'";
            String afterWhere1 = "Job_Id='%s' and Branch_Id='%s'";
            afterSet1 = String.format(afterSet1,"Done");
            afterWhere1 = String.format(afterWhere1,jobId,branch_Id);
            jobTable.update(afterSet1,afterWhere1);

            //get inventry item details (quantity and batch no) related to job from job_has_inventory_item table
            String where1="Job_ID="+jobId;
            ArrayList<String[]> result1= jobInventoryItemTable.select("*",where1);
            int noofrows=0;
            String inventoryItemId;
            String batchNo;
            int spendQuantity;
            for(String[] i : result1){
                inventoryItemId=i[1];
                batchNo=i[2];
                spendQuantity=Integer.parseInt(i[3]);

                //reduce that inventory items from branch_has_inventory_item table
                //get batch no and quantity from branch has inventory table
                int old_quntity=0;
                int new_quantity=0;

                //get the exsting quantity from inventoty_item_has_branch table
                String where2="inventory_item_Inventory_Item_Id="+inventoryItemId+" And batchNo="+batchNo;
                ArrayList<String[]> result2= inventoryItemBranchTable.select("quantity",where2);
                for(String[] j: result2) {

                    old_quntity=Integer.parseInt(j[0]);
                    new_quantity=old_quntity-spendQuantity;
                }

                //update quantity with batch no
                String afterSet2 = "quantity='%s'";
                String afterWhere2 = "inventory_item_Inventory_Item_Id='%s' and batchNo='%s'";
                afterSet2 = String.format(afterSet2,new_quantity);
                afterWhere2 = String.format(afterWhere2,inventoryItemId,batchNo);
                inventoryItemBranchTable.update(afterSet2,afterWhere2);
                noofrows+=1;
            }

            //add service record
            //get register client id from vehicle table
            ArrayList<String[]> result7= vehicleTable.select("Registered_Client_Id","Vehicle_Id="+vehicleId);
            for(String[] m:result7){
                clientId=m[0];
                out.println("client id ="+clientId);
            }

            //get description
            String description="Check Up";
            out.println(date);
            out.println(description);
            String attr4="Date,Description,Vehicle_Id,Registered_Client_Id";
            String vals4="'"+date+"','"+description+"',"+vehicleId+","+clientId;
            serviceRecordTable.insert(attr4,vals4);

            //redirect to the home page
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/SlotLeader/Home/home.jsp");
            requestDispatcher.forward(request,response);
        }catch (Exception e) {

            //if there is an error , redirect to the error page
            request.setAttribute("exception",e);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error/error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
