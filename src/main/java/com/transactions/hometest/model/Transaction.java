package com.transactions.hometest.model;


public class Transaction {
    private double amount;
    private long timestamp;

    public Transaction() {

    }

    public Transaction(double amount, long timestamp) {
        super();
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}