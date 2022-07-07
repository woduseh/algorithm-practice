package practice.modernjava.effective.programing.collection.javabeans;

import practice.modernjava.effective.programing.collection.Trade;

public class TradeBuilder {

    public final Trade trade = new Trade();
    private final MethodChainingOrderBuilder builder;

    TradeBuilder(MethodChainingOrderBuilder builder, Trade.Type type, int quantity) {
        this.builder = builder;
        trade.setType(type);
        trade.setQuantity(quantity);
    }

    public StockBuilder stock(String symbol) {
        return new StockBuilder(builder, trade, symbol);
    }
}
