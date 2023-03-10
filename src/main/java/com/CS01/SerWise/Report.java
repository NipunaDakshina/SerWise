package com.CS01.SerWise;

public class Report {
    int branchId;
    String month;
    String year;
    int appoinmentDone;
    int appoinmentOngoing;
    float income;
    float profit;
    int rank;

    public Report(int branchId, String month, String year, int appoinmentDone, float income, float profit, int rank) {
        this.branchId = branchId;
        this.month = month;
        this.year = year;
        this.appoinmentDone = appoinmentDone;
        this.income = income;
        this.profit = profit;
        this.rank = rank;
    }

    public Report(int branchId, String month, String year, int appoinmentDone, int appoinmentOngoing, float income, float profit, int rank) {
        this.branchId = branchId;
        this.month = month;
        this.year = year;
        this.appoinmentDone = appoinmentDone;
        this.appoinmentOngoing = appoinmentOngoing;
        this.income = income;
        this.profit = profit;
        this.rank = rank;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getAppoinmentDone() {
        return appoinmentDone;
    }

    public void setAppoinmentDone(int appoinmentDone) {
        this.appoinmentDone = appoinmentDone;
    }

    public int getAppoinmentOngoing() {
        return appoinmentOngoing;
    }

    public void setAppoinmentOngoing(int appoinmentOngoing) {
        this.appoinmentOngoing = appoinmentOngoing;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }


    @Override
    public String toString() {
        return "Report{" +
                "branchId=" + branchId +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", appoinmentDone=" + appoinmentDone +
                ", appoinmentOngoing=" + appoinmentOngoing +
                ", income=" + income +
                ", profit=" + profit +
                ", rank=" + rank +
                '}';
    }
}
