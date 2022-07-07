package practice.modernjava.effective.programing.collection;

public class Trade {

    public enum Type {BUY, SELL}

    private Type type;

    private Stock stock;
    private int quantity;
    public double price;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getValue() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s", type, stock, quantity, price, getValue());
    }
}
