package com.CS01.SerWise;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InventoryDBUtill {
    private DataSource dataSource;

    public InventoryDBUtill(DataSource theDataSource) {
        dataSource = theDataSource;
    }

    public List<Inventory> listInventory(int branch_Id){
        List<Inventory> inventory=new ArrayList<>();
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            connection = DatabaseConnection.initializeDatabase();
            String sql = "SELECT * FROM serwise.inventory_item where Branch_Id='" + branch_Id + "'";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int itemId=resultSet.getInt("Inventory_Item_Id");
                String itemName=resultSet.getString("Name");
                int quantity=resultSet.getInt("Quantity");
                String handlingDate =resultSet.getString("Handling_Time");
                String description=resultSet.getString("Description");
                int branchId=resultSet.getInt("Branch_Id");
                Inventory inventoryItem=new Inventory(itemId,itemName,quantity,handlingDate,description,branchId);
                inventory.add(inventoryItem);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection,statement,resultSet);
        }
        return inventory;
    }



    public List<Inventory> searchInventory(int branch_id, String item_name) {
        String name=item_name.toLowerCase();
        List<Inventory> inventoryList=new ArrayList<>();

        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            connection = DatabaseConnection.initializeDatabase();
            String sql = "SELECT * FROM serwise.inventory_item where lower(Name) Like '%"+name+"%';";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                int itemId=resultSet.getInt("Inventory_Item_Id");
                String itemName=resultSet.getString("Name");
                int quantity=resultSet.getInt("Quantity");
                String handlingDate =resultSet.getString("Handling_Time");
                String description=resultSet.getString("Description");
                int branchId=resultSet.getInt("Branch_Id");
                Inventory inventoryItem=new Inventory(itemId,itemName,quantity,handlingDate,description,branchId);
                inventoryList.add(inventoryItem);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection,statement,resultSet);
        }
        return inventoryList;
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

}
