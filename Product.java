import java.time.LocalDate;

public class Product {
    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean getDiscount() {
        return discount;
    }

    String type;
    double price;
    boolean discount =false;

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    LocalDate dateAdded;

    private Product() {
    }

    public Product(String type, double price) {
        this.type = type;
        this.price = price;
        this.dateAdded= LocalDate.now();
    }

    public Product(String type, double price, boolean discount) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.dateAdded= LocalDate.now();
    }

    public Product(String type, double price, boolean discount,LocalDate dateAdded) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.dateAdded= dateAdded;
    }
}
