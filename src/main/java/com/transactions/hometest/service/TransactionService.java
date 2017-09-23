package com.transactions.hometest.service;

import com.transactions.hometest.model.Transaction;
import java.sql.Timestamp;
import org.springframework.stereotype.Component;



@Component
public class TransactionService {

    public boolean isValid(long requestTimestamp){
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());

        long seconds = (timeStamp.getTime() - requestTimestamp)/1000;

        return (seconds < 60);
    }
}