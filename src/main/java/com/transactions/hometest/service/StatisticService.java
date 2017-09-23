package com.transactions.hometest.service;

import com.transactions.hometest.model.Statistic;
import org.springframework.stereotype.Component;

@Component
public class StatisticService {

    public Statistic getStatistics(){
        Statistic statistics = new Statistic(1000,100,200,50,10);
        return statistics;
    }
}