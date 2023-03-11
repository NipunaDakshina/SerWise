package com.CS01.SerWise;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReportDBUtill {
    private DataSource dataSource;

    public ReportDBUtill(DataSource theDataSource) {
        dataSource = theDataSource;
    }

    public static List<Report> getReport(int branch_id, int year, int month) {
        List<Report> report=new ArrayList<>();

        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            connection = DatabaseConnection.initializeDatabase();
            String sql = "SELECT * FROM serwise.appoinment where Branch_Id='" + branch_id + "'";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection,statement,resultSet);
        }

        return  report;

    }




    private static void close(Connection connection, Statement statement, ResultSet resultSet) {
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
}
