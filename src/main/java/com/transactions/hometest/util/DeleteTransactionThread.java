package com.transactions.hometest.util;

import com.transactions.hometest.service.ComputationService;
import static com.transactions.hometest.configuration.Configurations.TransactionOperation;


//This thread deletes the transactions from the system post timeout
public class DeleteTransactionThread implements Runnable {

    private TransactionOperation transactionOperation;
    private double amount;
    private long timestamp;
    private long timeout;

    public DeleteTransactionThread(TransactionOperation transactionOperation, double amount,
                                long timestamp, long timeout){
        this.transactionOperation = transactionOperation;
        this.amount = amount;
        this.timestamp = timestamp;
        this.timeout = timeout;
    }

    public void run() {
        try {
            Thread.sleep(timeout);
            ComputationService computationService = new ComputationService(transactionOperation,
                    amount, timestamp);

            computationService.updateStatistics();
        }
        catch(InterruptedException e) {

        }
    }
}
