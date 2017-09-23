package com.transactions.hometest.model;


public class Transaction {
    private double amount;
    private long timeStamp;

    public Transaction() {

    }

    public Transaction(double amount, long timeStamp) {
        super();
        this.amount = amount;
        this.timeStamp = timeStamp;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}