package com.transactions.hometest.util;

import com.transactions.hometest.service.ComputationService;
import static com.transactions.hometest.configuration.Configurations.TransactionOperation;



//This thread adds the transactions to the system
public class AddTransactionThread implements Runnable {

    private TransactionOperation transactionOperation;
    private double amount;
    private long timestamp;

    public AddTransactionThread(TransactionOperation transactionOperation, double amount, long timestamp){
        this.transactionOperation = transactionOperation;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public void run() {
        ComputationService computationService = new ComputationService(transactionOperation,
                amount, timestamp);

        computationService.updateStatistics();
    }
}
