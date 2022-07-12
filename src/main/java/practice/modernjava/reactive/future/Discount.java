package practice.modernjava.reactive.future;

import static practice.modernjava.reactive.future.Shop.randomDelay;

public class Discount {

    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);
        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String applyDiscount(Quote quote) {
        return quote.shopName() + " price is " + String.format("%.2f", apply(quote.price(),
                quote.discountCode())) + " and discount rank " + quote.discountCode();
    }

    private static double apply(double price, Code code) {
        randomDelay();
        return price * (100 - code.percentage) / 100;
    }
}
