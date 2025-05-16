package model.trade;

public class Stock {
    private String ProductName;
    private String ProductDescription;
    private int ProductPrice;
    private DayLimit daylimit;

    public Stock(String ProductName, String ProductDescription, int ProductPrice, DayLimit daylimit) {
        this.ProductName = ProductName;
        this.ProductDescription = ProductDescription;
        this.ProductPrice = ProductPrice;
        this.daylimit = daylimit;
    }

    @Override
    public String toString() {
        return String.format(
                "%s\n%s\nEnergy: %d, Time: %s, Ingredients: %s\nPrice: %s%d (%s)",
                ProductName, ProductDescription, ProductPrice,
                daylimit == DayLimit.unlimited ? "unlimited" : "limited"// for limited/unlimited
        );
    }
}
