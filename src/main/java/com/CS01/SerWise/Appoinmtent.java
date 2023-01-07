package com.CS01.SerWise;

public class Appoinmtent {

    private int appointmentId;
    private String date;
    private  String time;
    private  String description;
    private int clientId;
    private int branchId;
    private int vehicleId;

    public Appoinmtent(int appointmentId, String date, String time, String description, int clientId, int branchId, int vehicleId) {
        this.appointmentId = appointmentId;
        this.date = date;
        this.time = time;
        this.description = description;
        this.clientId = clientId;
        this.branchId = branchId;
        this.vehicleId = vehicleId;
    }

    public Appoinmtent(String date, String time, String description, int clientId, int branchId, int vehicleId) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.clientId = clientId;
        this.branchId = branchId;
        this.vehicleId = vehicleId;
    }

    public Appoinmtent(String parameter) {
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public String toString() {
        return "Appoinmtent{" +
                "appointmentId=" + appointmentId +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", description='" + description + '\'' +
                ", clientId=" + clientId +
                ", branchId=" + branchId +
                ", vehicleId=" + vehicleId +
                '}';
    }
}
