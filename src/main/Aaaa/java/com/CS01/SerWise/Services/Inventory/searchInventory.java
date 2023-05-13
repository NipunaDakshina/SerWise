package com.CS01.SerWise.Services.Inventory;

import com.CS01.SerWise.Controllers.inventoryItemBranchTable;
import com.CS01.SerWise.Controllers.inventoryItemTable;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ServletsearchInventory", value = "/ServletsearchInventory")
public class searchInventory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        //int employee_Id=(Integer)session.getAttribute("employeeId");
        String branch_Id;
        branch_Id = Integer.toString((Integer) session.getAttribute("branchId"));

        PrintWriter out=response.getWriter();

        String itemName=(String) request.getParameter("name");
        String name=null;

        out.println(itemName);
        if(itemName=="" || itemName==null){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ServletlistInventoryList");
            requestDispatcher.forward(request,response);
        }

        try {
            //String attr = "*";
            //String sql = "SELECT * FROM serwise.inventory_item where lower(Name) Like '%"+name+"%';";
            //String where= "lower('%s') and Like '%"+"'%s'"+"%'";
            //where= String.format(where,"Name",itemName);
            //out.println(where);
            //ArrayList<String[]> results = inventoryItemTable.select("*","Branch_Id="+branch_Id);
            //ArrayList<String[]> result1= inventoryItemBranchTable.select("*","lower(Name) Like '%"+itemName.toLowerCase()+"%'");
            ArrayList<String[]> result1= inventoryItemBranchTable.select("*","branch_Branch_ID="+branch_Id);
            int noofrows = 0;
            for (String[] i : result1){
                ArrayList<String[]> result2= inventoryItemTable.select("Name","Inventory_Item_Id="+i[0]);
                for(String[] j: result2){
                    name=j[0].toLowerCase();
                    if(name.contains(itemName.toLowerCase()) || itemName.toLowerCase().contains(name)){
                        request.setAttribute("itemId"+noofrows,i[0]);
                        request.setAttribute("branchId"+noofrows,i[1]);
                        request.setAttribute("batchNo"+noofrows,i[2]);
                        request.setAttribute("quantity"+noofrows,i[3]);
                        request.setAttribute("handlingTime"+noofrows,i[4]);
                        request.setAttribute("name"+noofrows,j[0]);
                        noofrows+=1;
                    }
                }
            }
            request.setAttribute("noOfRows",noofrows);
            //out.println("No of rows ="+noofrows);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/BranchManager/Inventory/viewInventory.jsp");
            requestDispatcher.forward(request,response);
        } catch (Exception e) {
            request.setAttribute("exception",e);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error/error.jsp");
            dispatcher.forward(request, response);
        }
    }
}


