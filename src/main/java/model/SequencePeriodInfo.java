package model;

import utils.ViewHelper;

import java.util.Arrays;

public class SequencePeriodInfo {


    private int periodValue;
    private boolean [] periodView;
    private int NumberOfPeriodEntries;


    public SequencePeriodInfo(){
        this.periodValue = 0;
        this.NumberOfPeriodEntries = 0;
        this.periodView = null;

    }

    public SequencePeriodInfo(int NumberOfPeriodEntries, int periodValue){
        this.periodValue = periodValue;
        this.NumberOfPeriodEntries = NumberOfPeriodEntries;
        this.periodView = null;

    }


    public SequencePeriodInfo(int periodValue,
                              boolean [] periodView,
                              int NumberOfPeriodEntries ) {
        this.periodValue = periodValue;
        this.NumberOfPeriodEntries = NumberOfPeriodEntries;
        this.periodView = periodView;
    }

    public int getPeriodValue() {
        return periodValue;
    }

    public boolean[] getPeriodView() {
        return periodView;
    }

    public int getNumberOfPeriodEntries() {
        return NumberOfPeriodEntries;
    }

    public void setPeriodValue(int periodValue) {
        this.periodValue = periodValue;
    }

    public void setPeriodView(boolean[] periodView) {
        this.periodView = periodView;
    }

    public void setNumberOfPeriodEntries(int numberOfPeriodEntries) {
        NumberOfPeriodEntries = numberOfPeriodEntries;
    }

    @Override
    public String toString() {
        return "SequencePeriodInfo{" +
                " periodValue = " + periodValue +
                ", periodView = " + ViewHelper.binViewAsString(periodView) +
                ", NumberOfPeriodEntries = " + NumberOfPeriodEntries +
                '}';
    }
}
