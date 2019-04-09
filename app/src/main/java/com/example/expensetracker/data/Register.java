package com.example.expensetracker.data;

public class Register {
    public enum Type{
        Expense,
        Income

    }
    private double value;
    private String description;
    private Type type;

    Register(float pvalue, String pdescription, Type ptype){
        value = pvalue;
        description = pdescription;
        type = ptype;
    }

    public double getValue() {
        return value;
    }

    public String getStringDecimalValue(){
        String str = "";
        str += Math.round(value * 100.0) / 100.0;
        return str;
    }

    public String getDescription(){
        return description;
    }

    void setValue(double value) {
        this.value = value;
    }

    public Type getType() {
        return type;
    }
}
