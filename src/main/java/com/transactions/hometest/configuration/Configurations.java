package com.transactions.hometest.configuration;

public final class Configurations {

    private Configurations() {
        // restrict instantiation
    }

    public static final int TRANSACTION_TIMEOUT = 60;

    public static enum TransactionOperation {
        TRANSACTION_ADD, TRANSACTION_DELETE;
    }
}
