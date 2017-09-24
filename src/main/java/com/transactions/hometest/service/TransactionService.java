package com.transactions.hometest.service;

import com.transactions.hometest.model.Transaction;
import java.sql.Timestamp;
import org.springframework.stereotype.Component;



@Component
public class TransactionService {

    public boolean isValid(long requestTimestamp, double amount){
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        long seconds = (currentTimestamp.getTime() - requestTimestamp)/1000;

        return (seconds < 60);
    }
}