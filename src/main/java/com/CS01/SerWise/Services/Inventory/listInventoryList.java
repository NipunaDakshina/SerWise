package com.CS01.SerWise.Services.Inventory;

import com.CS01.SerWise.Controllers.inventoryItemBranchTable;
import com.CS01.SerWise.Controllers.inventoryItemTable;
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

@WebServlet(name = "ServletlistInventoryList", value = "/ServletlistInventoryList")
public class listInventoryList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get branch  and employee id from the session
        HttpSession session=request.getSession();
        int employee_Id=(Integer)session.getAttribute("employeeId");
        String branch_Id=Integer.toString((Integer) session.getAttribute("branchId"));
        PrintWriter out=response.getWriter();

        try {

            //get inventory list related to branch
            ArrayList<String[]> result1= inventoryItemBranchTable.select("*","branch_Branch_ID="+branch_Id);
            int noofrows = 0;
            //get each inventory item details one by one
            for (String[] i : result1){
                request.setAttribute("itemId"+noofrows,i[0]);
                request.setAttribute("branchId"+noofrows,i[1]);
                request.setAttribute("batchNo"+noofrows,i[2]);
                request.setAttribute("quantity"+noofrows,i[3]);
                request.setAttribute("handlingTime"+noofrows,i[4]);

                //get the inventory item name from inventory table
                ArrayList<String[]> result2= inventoryItemTable.select("Name","Inventory_Item_Id="+i[0]);
                for(String[] j: result2){
                    //set inventory item name to the request
                    request.setAttribute("name"+noofrows,j[0]);
                }
                //to get next inventory item details
                noofrows+=1;

            }
            //set inventory item count
            request.setAttribute("noOfRows",noofrows);

            //redirect to the branch manager view inventory page
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/BranchManager/Inventory/viewInventory.jsp");
            requestDispatcher.forward(request,response);
        } catch (Exception e) {
            //if there is an error, redirect to the error page
            request.setAttribute("exception",e);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error/error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
