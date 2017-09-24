package com.transactions.hometest.service;

import java.sql.Timestamp;
import org.springframework.stereotype.Component;

import com.transactions.hometest.configuration.Configurations;
import com.transactions.hometest.model.Transaction;

import static com.transactions.hometest.configuration.Configurations.TRANSACTION_TIMEOUT;
import static com.transactions.hometest.configuration.Configurations.TransactionOperation;
import com.transactions.hometest.util.AddTransactionThread;
import com.transactions.hometest.util.DeleteTransactionThread;


@Component
public class TransactionService {

    public boolean isValid(long requestTimestamp){
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        long seconds = (currentTimestamp.getTime() - requestTimestamp)/1000;

        System.out.println(currentTimestamp.getTime() +  " " + requestTimestamp);
        return (seconds < TRANSACTION_TIMEOUT);
    }

    public void update(TransactionOperation transactionOperation, Transaction transaction) {

        double amount = transaction.getAmount();
        long requestTimestamp = transaction.getTimestamp();

        System.out.println("Reached update of Transaction");

        // Spawn Add transaction thread
        Runnable addTransactionThread = new AddTransactionThread(transactionOperation.TRANSACTION_ADD,
                amount, requestTimestamp);
        new Thread(addTransactionThread).start();

        // Compute timeout to sleep before deleting the transaction
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        long timeout = TRANSACTION_TIMEOUT * 1000 - ((currentTimestamp.getTime() - requestTimestamp));

        // Spawn Delete Transaction thread
        Runnable deleteTransactionThread = new DeleteTransactionThread(transactionOperation.TRANSACTION_DELETE,
                amount, requestTimestamp, timeout);
        new Thread(deleteTransactionThread).start();

        return;

    }


}