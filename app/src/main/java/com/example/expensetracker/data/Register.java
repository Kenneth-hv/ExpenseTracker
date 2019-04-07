package com.example.expensetracker.data;

abstract public class Register {
    private double value;
    private String description;

    Register(float pvalue, String pdescription){
        value = pvalue;
        description = pdescription;
    }

    public double getValue() {
        return value;
    }

    public String getStringDecimalValue(){
        String str = "₡";
        str += Math.round(value * 100.0) / 100.0;
        return str;
    }

    public String getDescription(){
        return description;
    }

    void setValue(double value) {
        this.value = value;
    }
}
