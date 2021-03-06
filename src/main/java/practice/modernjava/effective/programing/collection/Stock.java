package practice.modernjava.effective.programing.collection;

public class Stock {

    String symbol;
    String market;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    @Override
    public String toString() {
        return String.format("%s %s", symbol, market);
    }
}
