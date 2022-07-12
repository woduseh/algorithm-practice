package practice.modernjava.reactive.future;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

public class Shop {

    String name;
    static final RandomGenerator generator = RandomGenerator.of("L128X1024MixRandom");

    public Shop(String name) {
        this.name = name;
    }

    public String getPrice(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[generator.nextInt(
                Discount.Code.values().length)];

        return String.format("%s:%.2f:%s", name, price, code);
    }

    public Future<Double> getPriceAsync(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        randomDelay();
        return generator.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void randomDelay() {
        int delay = 500 + generator.nextInt(2000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> findPrices(String product, List<Shop> shops) {
        List<CompletableFuture<String>> priceFutures = shops.parallelStream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product)))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(
                        () -> Discount.applyDiscount(quote))))
                .toList();

        return priceFutures.stream().map(CompletableFuture::join).toList();
    }

    public Stream<CompletableFuture<String>> findPricesStream(String product, List<Shop> shops) {
        return shops.parallelStream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product)))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(
                        () -> Discount.applyDiscount(quote))));
    }
}
