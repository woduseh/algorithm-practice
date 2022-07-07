package practice.modernjava.effective.programing.collection;

import static practice.modernjava.effective.programing.collection.lambda.LambdaOrderBuilder.order;

public class StockTrade {

    public static void main(String[] args) {
        Order order = order(o -> {
            o.forCustomer("customer");
            o.buy(t -> {
                t.quantity(100);
                t.price(10.0);
                t.stock(s -> {
                    s.symbol("AAPL");
                    s.market("NASDAQ");
                });
            });
            o.sell(t -> {
                t.quantity(200);
                t.price(20.0);
                t.stock(s -> {
                    s.symbol("MSFT");
                    s.market("NASDAQ");
                });
            });
        });

        System.out.println(order);
    }
}
