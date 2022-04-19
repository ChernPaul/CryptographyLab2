package model;

import utils.ViewHelper;

import java.util.Arrays;
import java.util.List;

public class SequenceListPeriodInfo {


    private int periodValue;
    private List<Boolean> periodView;
    private int NumberOfPeriodEntries;


    public SequenceListPeriodInfo(){
        this.periodValue = 0;
        this.NumberOfPeriodEntries = 0;
        this.periodView = null;

    }

    public SequenceListPeriodInfo(int periodValue,
                              List<Boolean> periodView,
                              int NumberOfPeriodEntries ) {
        this.periodValue = periodValue;
        this.NumberOfPeriodEntries = NumberOfPeriodEntries;
        this.periodView = periodView;
    }

    public int getPeriodValue() {
        return periodValue;
    }

    public List<Boolean> getPeriodView() {
        return periodView;
    }

    public int getNumberOfPeriodEntries() {
        return NumberOfPeriodEntries;
    }

    public void setPeriodValue(int periodValue) {
        this.periodValue = periodValue;
    }

    public void setPeriodView(List<Boolean> periodView) {
        this.periodView = periodView;
    }

    public void setNumberOfPeriodEntries(int numberOfPeriodEntries) {
        NumberOfPeriodEntries = numberOfPeriodEntries;
    }

    @Override
    public String toString() {
        return "SequencePeriodInfo{" +
                " periodValue = " + periodValue +
                ", periodView = " + ViewHelper.binListViewAsString(periodView) +
                ", NumberOfPeriodEntries = " + NumberOfPeriodEntries +
                '}';
    }
}