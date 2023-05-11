package com.CS01.SerWise.Services.Employee;

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

@WebServlet(name = "ServletemployeeList", value = "/ServletemployeeList")
public class ServletemployeeList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        out.println("This is the employee list related to branch");
        HttpSession session=request.getSession();
        int employee_Id=(Integer)session.getAttribute("employeeId");
        String branch_Id;
        branch_Id = Integer.toString((Integer) session.getAttribute("branchId"));

        try {
            //get employee details related to branch excenpting branch manager details
            ArrayList<String[]> result1= employeeTable.select("*","Branch_Id="+branch_Id+" and Employee_Id!="+employee_Id);
            int noOfrows=0;
            out.println(result1.size());
            String position=null;
            for (String [] i:result1){
                request.setAttribute("employeeId"+noOfrows,i[0]);
                request.setAttribute("firstName"+noOfrows,i[1]);
                request.setAttribute("lastName"+noOfrows,i[2]);
                request.setAttribute("address"+noOfrows,i[3]);
                request.setAttribute("joinedDate"+noOfrows,i[4]);
                request.setAttribute("phoneNo"+noOfrows,i[5]);
                request.setAttribute("branchId"+noOfrows,i[6]);
                request.setAttribute("email"+noOfrows,i[7]);

                //check employee is mechanic
                ArrayList<String[]> emp1= mechanicTable.select("*","Employee_Id="+i[0]);
                if(emp1.size()>0){
                    position="Mechanic";
                }

                //check employee is washer
                ArrayList<String[]> emp2= washerTable.select("*","Employee_Id="+i[0]);
                if(emp2.size()>0){
                    position="Washer";
                }

                //check employee is slot leader
                ArrayList<String[]> emp3= slotLeaderTable.select("*","Employee_Id="+i[0]);
                if(emp3.size()>0){
                    position="Slot Leader";
                }

                //check employee is service advisor
                ArrayList<String[]> emp4= serviceAdvisorTable.select("*","Employee_Id="+i[0]);
                if(emp4.size()>0){
                    position="Service Advisor";
                }

                //check employee is store keeper
                ArrayList<String[]> emp5=storeKeeperTable.select("*","Employee_Id="+i[0]);
                if(emp5.size()>0){
                    position="Store Keeper";
                }

                //check employee is cachier
                ArrayList<String[]> emp6=cashierTable.select("*","Employee_Id="+i[0]);
                if(emp6.size()>0){
                    position="Cashier";
                }

                //check employee is security
                ArrayList<String[]> emp7=securityTable.select("*","Employee_Id="+i[0]);
                if(emp7.size()>0){
                    position="Security";
                }

                request.setAttribute("position"+noOfrows,position);
                out.println(position);
                noOfrows+=1;
            }
            request.setAttribute("noOfRows",noOfrows);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/BranchManager/Employee/viewEmployee.jsp");
            requestDispatcher.forward(request,response);
        } catch (Exception e) {
            request.setAttribute("exception",e);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Error/error.jsp");
            dispatcher.forward(request, response);
        }


    }

}
