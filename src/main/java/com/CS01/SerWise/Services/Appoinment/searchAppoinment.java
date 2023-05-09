package com.CS01.SerWise.Services.Appoinment;

import com.CS01.SerWise.Controllers.appoinmentTable;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ServletsearchAppoinment", value = "/ServletsearchAppoinment")
public class searchAppoinment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        //int employee_Id=(Integer)session.getAttribute("employeeId");
        String branch_Id;
        branch_Id = Integer.toString((Integer) session.getAttribute("branchId"));
        String id=request.getParameter("id");
        String date=request.getParameter("date");
        PrintWriter out=response.getWriter();
        out.println(id);
        out.println(date);
        if((id==null ||id=="")&&(date==null || date=="")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ServletlistAppoinment");
            requestDispatcher.forward(request,response);
        }
        else if(id!=null){
            String attr = "*";
            String where= "Appoinment_Id='%s' and Branch_Id='%s'";
            where= String.format(where,id,branch_Id);
            try {
                ArrayList<String[]> results = appoinmentTable.select("*",where);
                int noofrows = 0;
                for (String[] i : results){
                    request.setAttribute("appoinmentId"+noofrows,i[0]);
                    out.println(i[0]);
                    request.setAttribute("date"+noofrows,i[1]);
                    request.setAttribute("time"+noofrows,i[2]);
                    request.setAttribute("desription"+noofrows,i[3]);
                    request.setAttribute("clientId"+noofrows,i[4]);
                    request.setAttribute("branchId"+noofrows,i[5]);
                    request.setAttribute("vehicleId"+noofrows,i[6]);
                    noofrows+=1;
                }
                request.setAttribute("noOfRows",noofrows);
                out.println("No of rows ="+noofrows);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/BranchManager/Appoinment/viewAppoinment.jsp");
                requestDispatcher.forward(request,response);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }


        else if(date!=null){
            String attr = "*";
            String where= "Date='%s' and Branch_Id='%s'";
            where= String.format(where,date,branch_Id);
            try {
                ArrayList<String[]> results = appoinmentTable.select("*",where);
                int noofrows = 0;
                for (String[] i : results){
                    request.setAttribute("appoinmentId"+noofrows,i[0]);
                    out.println(i[0]);
                    request.setAttribute("date"+noofrows,i[1]);
                    request.setAttribute("time"+noofrows,i[2]);
                    request.setAttribute("desription"+noofrows,i[3]);
                    request.setAttribute("clientId"+noofrows,i[4]);
                    request.setAttribute("branchId"+noofrows,i[5]);
                    request.setAttribute("vehicleId"+noofrows,i[6]);
                    noofrows+=1;
                }
                request.setAttribute("noOfRows",noofrows);
                out.println("No of rows ="+noofrows);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/BranchManager/Appoinment/viewAppoinment.jsp");
                requestDispatcher.forward(request,response);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
