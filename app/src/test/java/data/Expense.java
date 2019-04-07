package data;

public class Expense extends Register {
    public enum Category{
        FIXED,
        SERVICES,
        PRODUCTS,
        LEISURE,
        IMPREVIST,
        OTHER
    }

    private Category category;

    Expense(float pvalue, String pdescription, Category pcategory) {
        super(pvalue, pdescription);
        category = pcategory;

    }

    public Category getCategory() {
        return category;
    }

    public String getExpenseCategory(){
        switch (category){
            case FIXED:
                return "Gastos Fijos";
            case SERVICES:
                return "Pago de Servicios";
            case PRODUCTS:
                return "Compra de Productos";
            case LEISURE:
                return "Ocio";
            case IMPREVIST:
                return "Imprevisto";
            case OTHER:
                return "Otro";
        }
    }
}
