package com.transactions.hometest.model;


public class Statistic {
    private double sum;
    private double avg;
    private double max;
    private double min;
    private long count;

    public Statistic(double sum, double avg, double max, double min, long count) {
        super();
        this.sum = sum;
        this.avg = avg;
        this.max = max;
        this.min = min;
        this.count = count;
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