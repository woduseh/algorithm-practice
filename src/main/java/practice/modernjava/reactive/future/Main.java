package practice.modernjava.reactive.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Shop shop = new Shop("Shop");

        List<Shop> shops = Arrays.asList(
                new Shop("BestShop"),
                new Shop("SecondBestShop"),
                new Shop("ThirdBestShop"),
                new Shop("FourthBestShop"),
                new Shop("FifthBestShop"),
                new Shop("SixthBestShop"),
                new Shop("SeventhBestShop"),
                new Shop("EighthBestShop"),
                new Shop("NinthBestShop"),
                new Shop("TenthBestShop"));

        long invocationTime = System.currentTimeMillis();

//        shop.findPrices("myProduct", shops);

        CompletableFuture[] futures = shop.findPricesStream("myProduct", shops)
                .map(future -> future.thenAccept(s -> System.out.println(
                        s + " (done in " + (System.currentTimeMillis() - invocationTime) + "ms)")))
                .toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(futures).join();

        long retrievalTime = System.currentTimeMillis();
        System.out.println(
                "All shops  have now responses in: " + (retrievalTime - invocationTime) + "ms");
    }

}
