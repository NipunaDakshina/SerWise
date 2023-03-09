package com.CS01.SerWise;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppoinmentDBUtill {

    private DataSource dataSource;

    public AppoinmentDBUtill(DataSource theDataSource) {
        dataSource = theDataSource;
    }





    // method for listing all appoinments related to given branch id
    public List<Appoinmtent> listAppoinments(int branch_Id){
        List<Appoinmtent> appoinmtents=new ArrayList<>();
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            connection = DatabaseConnection.initializeDatabase();
            String sql = "SELECT * FROM serwise.appoinment where Branch_Id='" + branch_Id + "'";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int appoinmentId=resultSet.getInt("Appoinment_Id");
                String date=resultSet.getString("Date");
                String time=resultSet.getString("Time");
                String description=resultSet.getString("Desription");
                int clientId=resultSet.getInt("Registered_Client_Id");
                int branchId=resultSet.getInt("Branch_Id");
                int vehicleId=resultSet.getInt("Vehicle_Id");
                Appoinmtent tempAppoinmtent=new Appoinmtent(appoinmentId,date,time,description,clientId,branchId,vehicleId);
                appoinmtents.add(tempAppoinmtent);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection,statement,resultSet);
        }
        return appoinmtents;
    }

    //method for updating an appoinment if appoinment id, date and time are  given
    public  int resheduleAppoinment( int branch_Id,int appoinment_Id,String date, String time){
        Connection connection=null;
        PreparedStatement statement=null;
        int affectedRow=0;
        try {
            connection = DatabaseConnection.initializeDatabase();
            //String sql = "SELECT * FROM serwise.appoinment where Branch_Id='" + branch_Id + "'";
            String sql="update serwise.appoinment set Date=? ,Time=? where Appoinment_Id=? and  Branch_Id=?";
            statement=connection.prepareStatement(sql);

            statement.setString(1,date);
            statement.setString(2,time);
            statement.setInt(3,appoinment_Id);
            statement.setInt(4,branch_Id);

            affectedRow=statement.executeUpdate();
            if(affectedRow==1){
                return 1;
            }
            else {
             return 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection,statement);
        }

    }
    //method for removing an appoinment if appoinment id is given
    public int removeAppoinment(int branch_Id,int appoinment_Id){
        Connection connection=null;
        PreparedStatement statement=null;
        int affectedRow=0;
        try {
            connection = DatabaseConnection.initializeDatabase();
            //String sql = "SELECT * FROM serwise.appoinment where Branch_Id='" + branch_Id + "'";
            String sql="DELETE  FROM  serwise.appoinment where Appoinment_Id=? and  Branch_Id=?";
            statement=connection.prepareStatement(sql);

            statement.setInt(1,appoinment_Id);
            statement.setInt(2,branch_Id);

            affectedRow=statement.executeUpdate();
            if(affectedRow==1){
                return 1;
            }
            else {
                return 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection,statement);
        }
    }




    //method for searching an appoinment if id  and date are given

    public List<Appoinmtent> searchAppoinments(int branch_Id,int filterId,String filterDate) {
        List<Appoinmtent> appoinmtents=new ArrayList<>();
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        String sql=null;
        //out.println(theCommand);
        //out.println(filterId);
        //out.println(filterDate);
        try {
            connection = DatabaseConnection.initializeDatabase();


            if (filterDate !="" && filterId ==0) {
                sql = "SELECT * FROM serwise.appoinment where Branch_Id='" + branch_Id + "' AND Date='"+filterDate+"';";
            }
            else if (filterDate =="" && filterId !=0) {
                sql = "SELECT * FROM serwise.appoinment where Branch_Id='" + branch_Id + "' AND Appoinment_Id="+filterId+";";
            }
            else if (filterDate != "" && filterId !=0) {
                sql = "SELECT * FROM serwise.appoinment where Branch_Id='" + branch_Id + "' AND Date='"+filterDate+"' AND Appoinment_Id="+filterId+";";
            }
            else{
                sql = "SELECT * FROM serwise.appoinment where Branch_Id='" + branch_Id + "'";
            }
            //out.println(sql);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int appoinmentId=resultSet.getInt("Appoinment_Id");
                String date=resultSet.getString("Date");
                String time=resultSet.getString("Time");
                String description=resultSet.getString("Desription");
                int clientId=resultSet.getInt("Registered_Client_Id");
                int branchId=resultSet.getInt("Branch_Id");
                int vehicleId=resultSet.getInt("Vehicle_Id");
                Appoinmtent tempAppoinmtent=new Appoinmtent(appoinmentId,date,time,description,clientId,branchId,vehicleId);
                appoinmtents.add(tempAppoinmtent);
                //out.println(tempAppoinmtent);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            close(connection,statement,resultSet);
        }

        return  appoinmtents;
    }



























    private void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if(resultSet !=null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        catch (Exception exc){
            exc.printStackTrace();
        }
    }

    private void close(Connection connection, PreparedStatement statement) {
        try {
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        catch (Exception exc){
            exc.printStackTrace();
        }

    }
}
