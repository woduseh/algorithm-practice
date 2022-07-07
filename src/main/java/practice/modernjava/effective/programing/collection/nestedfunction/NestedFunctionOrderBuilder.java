package practice.modernjava.effective.programing.collection.nestedfunction;

import java.util.stream.Stream;
import practice.modernjava.effective.programing.collection.Order;
import practice.modernjava.effective.programing.collection.Stock;
import practice.modernjava.effective.programing.collection.Trade;

public class NestedFunctionOrderBuilder {

    public static Order order(String customer, Trade... trades) {
        Order order = new Order();
        order.setCustomer(customer);
        Stream.of(trades).forEach(order::addTrade);
        return order;
    }

    public static Trade buy(int quantity, Stock stock, double price) {
        return buildTrade(Trade.Type.BUY, quantity, stock, price);
    }

    public static Trade sell(int quantity, Stock stock, double price) {
        return buildTrade(Trade.Type.SELL, quantity, stock, price);
    }

    private static Trade buildTrade(Trade.Type type, int quantity, Stock stock, double price) {
        Trade trade = new Trade();
        trade.setQuantity(quantity);
        trade.setStock(stock);
        trade.setPrice(price);
        trade.setType(type);
        return trade;
    }

    public static double at(double price) {
        return price;
    }

    public static Stock stock(String symbol, String market) {
        Stock stock = new Stock();
        stock.setSymbol(symbol);
        stock.setMarket(market);
        return stock;
    }

    public static String on(String market) {
        return market;
    }
}
