package com.transactions.hometest.service;

import com.transactions.hometest.model.Statistic;
import java.util.*;

import static com.transactions.hometest.configuration.Configurations.TransactionOperation;

public class ComputationService {

    private TransactionOperation transactionOperation;
    private double amount;
    private long timestamp;
    static List<Double> sortedTransactions = new ArrayList();

    public ComputationService(TransactionOperation transactionOperation, double amount, long timestamp){
        this.transactionOperation = transactionOperation;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public void updateStatistics() {

        synchronized (Statistic.getInstance()) {
            Statistic statistic = Statistic.getInstance();
            double sum = statistic.getSum();
            double avg = statistic.getAvg();
            double max = statistic.getMax();
            double min = statistic.getMin();
            long count = statistic.getCount();

            if (transactionOperation == TransactionOperation.TRANSACTION_ADD){
                sortedTransactions.add(amount);
                Collections.sort(sortedTransactions);

                statistic.setSum(sum += amount);
                statistic.setCount(++count);
                statistic.setAvg(sum/count);
                statistic.setMax(sortedTransactions.get(sortedTransactions.size() - 1));
                statistic.setMin(sortedTransactions.get(0));

            }
            else if (transactionOperation == TransactionOperation.TRANSACTION_DELETE) {
                sortedTransactions.remove(amount);

                statistic.setSum(sum -= amount);
                statistic.setCount(--count);
                statistic.setAvg((count == 0) ? 0 : sum/count);
                statistic.setMax((sortedTransactions.size() == 0) ? 0:
                        sortedTransactions.get(sortedTransactions.size() - 1));
                statistic.setMin((sortedTransactions.size() == 0) ? Double.MAX_VALUE : sortedTransactions.get(0));

            }
        }
    }

}