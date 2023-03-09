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

@WebServlet(name = "ServletAppoinmentController", value = "/ServletAppoinmentController")
public class ServletAppoinmentController extends HttpServlet {


    private AppoinmentDBUtill appoinmentDBUtill;

    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        // create our student db util ... and pass in the conn pool / datasource
        try {
            appoinmentDBUtill = new AppoinmentDBUtill(dataSource);
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
            listAppoinments(request,response);
        }else if(theCommand.equals("RESHEDULE")){
            resheduleAppoinment(request,response);
        } else if (theCommand.equals("REMOVE")) {
            removeAppoinment(request,response);
        } else if (theCommand.equals("SEARCH")) {
            searchAppoinment(request,response);
        }


    }


    private void listAppoinments(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        int employee_Id=(Integer)session.getAttribute("employeeId");
        int branch_Id=(Integer) session.getAttribute("branchId");

        List<Appoinmtent> appoinmtents=appoinmentDBUtill.listAppoinments(branch_Id);


        request.setAttribute("APPOINMENTS",appoinmtents);
        RequestDispatcher rd=request.getRequestDispatcher("BranchManager/Appoinments/appoinments.jsp");
        rd.forward(request,response);
    }

    private  void resheduleAppoinment(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();
        //int employee_Id=(Integer)session.getAttribute("employeeId");
        int branch_Id=(Integer) session.getAttribute("branchId");

        int appoinmentID=Integer.parseInt((String) request.getParameter("id"));
        String old_date=(String) request.getParameter("old_date");
        String old_time=(String) request.getParameter("old_time");
        String new_date=(String) request.getParameter("new_date");
        String new_time=(String) request.getParameter("new_time");
        String date,time;

        if (new_date!="" && new_time !=""){
            date=new_date;
            time=new_time;

        }
        else if(new_date!="" && new_time==""){
            date=new_date;
            time=old_time;
        }
        else if(new_date=="" && new_time!="") {
            date=old_date;
            time=new_time;
        }
        else {
            date=old_date;
            time=old_time;
        }
        PrintWriter out=response.getWriter();
        /*
        out.println(branch_Id);
        out.println(appoinmentID);
        out.println(date);
        out.println(time);
       */
        int result= appoinmentDBUtill.resheduleAppoinment(branch_Id,appoinmentID,date,time);
        if(result==1){
            listAppoinments(request,response);
        }
        else{
            System.out.println("there is an error");
        }
    }

    private  void  removeAppoinment(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        int appoinmentID=Integer.parseInt((String) request.getParameter("id"));
        HttpSession session=request.getSession();
        //int employee_Id=(Integer)session.getAttribute("employeeId");
        int branch_Id=(Integer) session.getAttribute("branchId");

        PrintWriter out=response.getWriter();
        //out.println(branch_Id);
        //out.println(appoinmentID);

        int result= appoinmentDBUtill.removeAppoinment(branch_Id,appoinmentID);
        if(result==1){
            listAppoinments(request,response);
        }
        else {
            System.out.println("there is an error");
        }
    }

    private  void  searchAppoinment(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        int employee_Id=(Integer)session.getAttribute("employeeId");
        int branch_Id=(Integer) session.getAttribute("branchId");

        String filterDate=null;
        filterDate=request.getParameter("DATE");
        String Id=null;
        Id=request.getParameter("ID");
        int filterId=0;
        if(Id==""){
            filterId=0;
        }
        else{
            filterId=Integer.parseInt(Id);
        }

        List<Appoinmtent> appoinmtents=appoinmentDBUtill.searchAppoinments(branch_Id,filterId,filterDate);

        request.setAttribute("APPOINMENTS",appoinmtents);
        RequestDispatcher rd=request.getRequestDispatcher("BranchManager/Appoinments/appoinments.jsp");
        rd.forward(request,response);


    }


}
