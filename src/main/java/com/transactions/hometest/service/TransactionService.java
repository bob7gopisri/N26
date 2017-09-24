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

    /* This method returns if the transaction timestamp falls in the last 60 seconds or not */
    public boolean isValid(long requestTimestamp){
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        long seconds = (currentTimestamp.getTime() - requestTimestamp)/1000;

        return (seconds < TRANSACTION_TIMEOUT);
    }

    /* This method spawns threads and inserts/deletes the transactions. We have already
    validated that the transaction falls in the 60 seconds window */
    public void update(TransactionOperation transactionOperation, Transaction transaction) {

        double amount = transaction.getAmount();
        long requestTimestamp = transaction.getTimestamp();

        // Compute timeout to sleep before inserting and deleting the transaction
        long currentTimestamp = new Timestamp(System.currentTimeMillis()).getTime();

        long addTimeout = 0;
        long deleteTimeout = 0;

        // If we get a future transaction, don't insert right away,
        // rather wait until the requestTimestamp matches epoch time, i.e. addTimeout will be > 0
        if (requestTimestamp > currentTimestamp){
            addTimeout = requestTimestamp - currentTimestamp;
            deleteTimeout = addTimeout + TRANSACTION_TIMEOUT * 1000;
        }
        else {
            // Else, insert right away and delete the transaction at (requestTimeStamp + 60000)milliseconds UTC timestamp
            addTimeout = 0;
            deleteTimeout = TRANSACTION_TIMEOUT * 1000 - ((currentTimestamp - requestTimestamp));
        }

        // Spawn Add transaction thread
        Runnable addTransactionThread = new AddTransactionThread(transactionOperation.TRANSACTION_ADD,
                amount, requestTimestamp, addTimeout);
        new Thread(addTransactionThread).start();

        // Spawn Delete Transaction thread
        Runnable deleteTransactionThread = new DeleteTransactionThread(transactionOperation.TRANSACTION_DELETE,
                amount, requestTimestamp, deleteTimeout);
        new Thread(deleteTransactionThread).start();

        return;

    }


}