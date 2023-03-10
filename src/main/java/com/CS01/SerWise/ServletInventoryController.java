package com.CS01.SerWise;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletInventory", value = "/ServletInventory")
public class ServletInventoryController extends HttpServlet {
    private InventoryDBUtill inventoryDBUtill;

    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        // create our student db util ... and pass in the conn pool / datasource
        try {
            inventoryDBUtill = new InventoryDBUtill(dataSource);
        }
        catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        int employee_Id=(Integer)session.getAttribute("employeeId");
        int branch_Id=(Integer) session.getAttribute("branchId");
        PrintWriter out=response.getWriter();
        String theCommand =(String) request.getParameter("command");

        if(theCommand.equals("LIST")) {
            listInventory(request,response);
        }
        if(theCommand.equals("SEARCH")){
            searchInventory(request,response);
        }








    }


    private void listInventory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        int employee_Id=(Integer)session.getAttribute("employeeId");
        int branch_Id=(Integer) session.getAttribute("branchId");

        List<Inventory> inventoryList=inventoryDBUtill.listInventory(branch_Id);

        request.setAttribute("INVENTORY",inventoryList);
        RequestDispatcher rd=request.getRequestDispatcher("BranchManager/Inventory/inventory.jsp");
        rd.forward(request,response);


    }


    private void searchInventory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session=request.getSession();
        int employee_Id=(Integer)session.getAttribute("employeeId");
        int branch_Id=(Integer) session.getAttribute("branchId");

        String itemName=(String) request.getParameter("item_name");
        PrintWriter out=response.getWriter();
        //out.println(itemName);

        if(itemName==""){
            listInventory(request,response);
        }
        else {
            List<Inventory> searchList=inventoryDBUtill.searchInventory(branch_Id,itemName);

            if (searchList.isEmpty()){
                request.setAttribute("INVENTORY",searchList);
                RequestDispatcher rd=request.getRequestDispatcher("BranchManager/Inventory/inventory.jsp");
                rd.forward(request,response);
            }
            else{
                request.setAttribute("INVENTORY",searchList);
                RequestDispatcher rd=request.getRequestDispatcher("BranchManager/Inventory/inventory.jsp");
                rd.forward(request,response);
            }
        }




    }

}
