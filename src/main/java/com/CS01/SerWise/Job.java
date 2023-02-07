package com.CS01.SerWise;

public class Job {
    private int appointmentId;
    private String date;
    private String time;

    public Job(int appointmentId, String date, String time) {
        this.appointmentId = appointmentId;
        this.date = date;
        this.time = time;
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

    @Override
    public String toString() {
        return "Jobs{" +
                "appointmentId=" + appointmentId +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
