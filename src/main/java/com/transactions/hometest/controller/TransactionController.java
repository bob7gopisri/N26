package com.transactions.hometest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.transactions.hometest.model.Transaction;
import com.transactions.hometest.service.TransactionService;
import static com.transactions.hometest.configuration.Configurations.TransactionOperation;

@Controller
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/transactions", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity< Void > transactionsResponse(@RequestBody Transaction transaction) {
        if (transactionService.isValid(transaction.getTimestamp())){
            transactionService.update(TransactionOperation.TRANSACTION_ADD, transaction);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}