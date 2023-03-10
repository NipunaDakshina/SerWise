package com.CS01.SerWise;

public class Inventory {

    private int itemId;
    private String itemName;
    private float Quantity;
    private String handlingDate;
    private String description;
    private int branchID;

    public Inventory(int itemId, String itemName, float quantity, String handlingDate, String description, int branchID) {
        this.itemId = itemId;
        this.itemName = itemName;
        Quantity = quantity;
        this.handlingDate = handlingDate;
        this.description = description;
        this.branchID = branchID;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getQuantity() {
        return Quantity;
    }

    public void setQuantity(float quantity) {
        Quantity = quantity;
    }

    public String getHandlingDate() {
        return handlingDate;
    }

    public void setHandlingDate(String handlingDate) {
        this.handlingDate = handlingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", Quantity=" + Quantity +
                ", handlingDate='" + handlingDate + '\'' +
                ", description='" + description + '\'' +
                ", branchID=" + branchID +
                '}';
    }
}
