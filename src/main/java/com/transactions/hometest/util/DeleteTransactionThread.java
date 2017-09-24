package com.transactions.hometest.util;

import java.sql.Timestamp;

import com.transactions.hometest.service.ComputationService;
import static com.transactions.hometest.configuration.Configurations.TransactionOperation;


//This thread deletes the transactions from the system post timeout
public class DeleteTransactionThread implements Runnable {

    private TransactionOperation transactionOperation;
    private double amount;
    private long timestamp;
    private long deleteTimeout;

    public DeleteTransactionThread(TransactionOperation transactionOperation, double amount,
                                long timestamp, long deleteTimeout){
        this.transactionOperation = transactionOperation;
        this.amount = amount;
        this.timestamp = timestamp;
        this.deleteTimeout = deleteTimeout;
    }

    public void run() {
        try {
            if (deleteTimeout > 0){
                Thread.sleep(deleteTimeout);
            }
            System.out.println("Delete Transaction Thread for amount: " + amount + " after " + deleteTimeout/1000 + "s");

            ComputationService computationService = new ComputationService(transactionOperation,
                    amount, timestamp);

            computationService.updateStatistics();
        }
        catch(InterruptedException e) {

        }
    }
}
