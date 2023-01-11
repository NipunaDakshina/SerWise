package com.CS01.SerWise;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "ServletLogIn", value = "/ServletLogIn")
public class ServletLogIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String uname=(String) request.getParameter("uname");
        String password=(String) request.getParameter("pw");
        //response.sendRedirect("/BranchManager/Home/home.html");
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            con=DatabaseConnection.initializeDatabase();

            String sql1="select * from serwise.user where username='"+uname+"'";


            stmt= con.createStatement();

            rs=stmt.executeQuery(sql1);

            rs.next();
            String dbUser=rs.getString("username");
            String dbPass=rs.getString("password");
            int dbRole=Integer.parseInt(rs.getString("role"));

            if(uname.equals(dbUser) && password.equals(dbPass)){
                    if(dbRole==5) {
                        //below code is used for get the branch details related to branch manager and set them in a request
                        try {


                            String sql2 = "SELECT * FROM serwise.employee where username='" + uname + "'";
                            stmt=con.createStatement();
                            rs=stmt.executeQuery(sql2);
                            rs.next();
                            int branchId=rs.getInt("Branch_Id");
                            int employeeId=rs.getInt("Employee_Id");
                            HttpSession session=request.getSession();
                            session.setAttribute("employeeId",employeeId);
                            session.setAttribute("branchId",branchId);
                            response.sendRedirect("/SerWise_war/BranchManager/Home/home.jsp");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
            }
            else {
                //out.println(uname);
                out.println(dbUser);
                //out.println(password);
                out.println(dbPass);
                out.println(dbRole);
                response.sendRedirect("/SerWise_war/Login/login.html");
            }



        } catch (SQLException e) {
            //response.sendRedirect("/SerWise_war/Login/login.html");
            throw new RuntimeException(e);
            //out.println(uname);
            //out.println(dbUser);
            //out.println(password);
            //out.println(dbPass);
        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);
        }
        finally {
            close(con,stmt,rs);
        }

    }

    private void close(Connection con, Statement stmt, ResultSet rs) {
        try {
            if(rs !=null){
                rs.close();
            }
            if(stmt != null){
                stmt.close();
            }
            if(con != null){
                con.close();
            }
        }
        catch (Exception exc){
            exc.printStackTrace();
        }
    }


}

