package com.CS01.SerWise;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletViewAppointments", value = "/ServletViewAppointments")
public class ServletAppointments extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String theCommand=request.getParameter("command");
        out.println(theCommand);



        if(theCommand.equals("LIST")){
            List<Appoinmtent> appoinmtents=new ArrayList<>();
            Connection connection=null;
            Statement statement=null;
            ResultSet resultSet=null;



        }

        else if(theCommand.equals("UPDATE")){



        }




    }
}

