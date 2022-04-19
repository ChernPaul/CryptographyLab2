package model;
import constants.Constants;

public class LFSRGenerator {
    private  boolean [] startCondition;
    private boolean [] coefficients;

    public  LFSRGenerator(){
        this.startCondition =  null;
        this.coefficients = null;
    }

    public LFSRGenerator(boolean[] startCondition, boolean[] coefficients) {
        this.startCondition = startCondition;
        this.coefficients = coefficients;
    }

    public boolean[] getStartCondition() {
        return startCondition;
    }

    public boolean[] getCoefficients() {
        return coefficients;
    }

    public void setStartCondition(boolean[] startCondition) {
        this.startCondition = startCondition;
    }

    public void setCoefficients(boolean[] coefficients) {
        this.coefficients = coefficients;
    }

    public boolean moveToNextState(){

        boolean result = startCondition[0];

        boolean lastStepValue = startCondition[0] & coefficients[0];
        boolean[] newCondition = new boolean[startCondition.length];
        for(int i = 0; i < startCondition.length - Constants.VALUE_ONE; i++){

            newCondition[i] = startCondition[i + Constants.VALUE_ONE];
        }

        for(int i = 1; i < coefficients.length; i++ ){
            boolean currentStepValue = startCondition[i] & coefficients[i];
            lastStepValue = currentStepValue ^ lastStepValue;
        }
        newCondition[startCondition.length - Constants.VALUE_ONE] = lastStepValue;
        setStartCondition(newCondition);
        return result;
    }

    public boolean[] generateSequence(int sequenceLength){
        boolean[] result = new boolean[sequenceLength];
        for(int i = 0; i < sequenceLength; i++ ){
            result[i] = this.moveToNextState();
        }
        return result;
    }



}
