package data;

abstract public class Register {
    private double value;
    private String description;

    protected Register(float pvalue, String pdescription){
        value = pvalue;
        description = pdescription;
    }

    public double getValue() {
        return value;
    }

    public String getStringDecimalValue(){
        String str = "₡";
        str += Math.round(value * 100.0) / 1000;
        return str;
    }

    public String getDescription(){
        return description;
    }

    void setValue(double value) {
        this.value = value;
    }
}
