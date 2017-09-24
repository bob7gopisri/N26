package com.transactions.hometest.model;


public class Statistic {
    private static Statistic statistics_instance = null;

    private double sum;
    private double avg;
    private double max;
    private double min;
    private long count;

    private Statistic()
    {
        this.sum = 0;
        this.avg = 0;
        this.max = 0;
        this.min = 0;
        this.count = 0;
    }

    // static method to create instance of Singleton class
    public static Statistic getInstance()
    {
        if (statistics_instance == null)
            statistics_instance = new Statistic();

        return statistics_instance;
    }

    public double getSum() {
        return sum;
    }

    public double getAvg() {
        return avg;
    }

    public double getMax() {return max;}

    public double getMin() {return min;}

    public long getCount() {return count;}
}