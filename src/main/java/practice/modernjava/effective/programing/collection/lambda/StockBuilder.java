package practice.modernjava.effective.programing.collection.lambda;

import practice.modernjava.effective.programing.collection.Stock;

public class StockBuilder {

    public Stock stock = new Stock();

    public void symbol(String symbol) {
        stock.setSymbol(symbol);
    }

    public void market(String market) {
        stock.setMarket(market);
    }
}
