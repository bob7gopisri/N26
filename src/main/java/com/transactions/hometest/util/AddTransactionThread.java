package com.transactions.hometest.util;

import java.sql.Timestamp;

import com.transactions.hometest.service.ComputationService;
import static com.transactions.hometest.configuration.Configurations.TransactionOperation;



//This thread adds the transactions to the system
public class AddTransactionThread implements Runnable {

    private TransactionOperation transactionOperation;
    private double amount;
    private long timestamp;
    private long addTimeout;

    public AddTransactionThread(TransactionOperation transactionOperation, double amount,
                                long timestamp, long addTimeout){
        this.transactionOperation = transactionOperation;
        this.amount = amount;
        this.timestamp = timestamp;
        this.addTimeout = addTimeout;
    }

    public void run() {
        try {
            if (addTimeout > 0) {
                Thread.sleep(addTimeout);
            }

            ComputationService computationService = new ComputationService(transactionOperation,
                    amount, timestamp);

            computationService.updateStatistics();
        }
        catch(InterruptedException e) {

        }
    }
}
