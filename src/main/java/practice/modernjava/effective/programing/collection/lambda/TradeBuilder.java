package practice.modernjava.effective.programing.collection.lambda;

import java.util.function.Consumer;
import practice.modernjava.effective.programing.collection.Trade;

public class TradeBuilder {

    Trade trade = new Trade();

    public void quantity(int quantity) {
        trade.setQuantity(quantity);
    }

    public void price(double price) {
        trade.setPrice(price);
    }

    public void stock(Consumer<StockBuilder> consumer) {
        StockBuilder builder = new StockBuilder();
        consumer.accept(builder);
        trade.setStock(builder.stock);
    }
}
