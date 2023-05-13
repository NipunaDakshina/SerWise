package com.CS01.SerWise;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "ServletDatabase", value = "/ServletDatabase")
public class ServletDatabase extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
        pw.println("<html><body>");
        //initializing connections
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3305/serwise","root","");
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from serwise.branch");
            while (rs.next()){
                pw.println("<br>"+rs.getInt("Branch_id")+"<br>"+rs.getString("Location")+"<br>"+rs.getInt("Number_of_Slots"));
            };
        }// End of try block
        catch(Exception e) {e.printStackTrace();}
        pw.println("</body></html>");
    }


}
