package com.transactions.hometest.service;

import com.transactions.hometest.model.Statistic;
import static com.transactions.hometest.configuration.Configurations.TransactionOperation;

public class ComputationService {

    private TransactionOperation transactionOperation;
    private double amount;
    private long timestamp;

    public ComputationService(TransactionOperation transactionOperation, double amount, long timestamp){
        this.transactionOperation = transactionOperation;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public void updateStatistics() {
//            Statistic.getInstance().updateStatistics(100.5,53.6,20.0,1.0,(long)10);
    }

}