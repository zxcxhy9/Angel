package com.xhy.angel;

import org.apache.commons.lang.math.RandomUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureTest {

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        long start = System.currentTimeMillis();
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + RandomUtils.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "商品详情";
        }, executorService);

        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + RandomUtils.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "卖家信息";
        }, executorService);

        CompletableFuture<String> futureC = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + RandomUtils.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "库存信息";
        }, executorService);

        CompletableFuture<String> futureD = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 + RandomUtils.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "订单信息";
        }, executorService);

        CompletableFuture<Void> allFuture = CompletableFuture.allOf(futureA, futureB, futureC, futureD);
        allFuture.join();

        System.out.println(futureA.join());
        System.out.println(futureB.join());
        System.out.println(futureC.join());
        System.out.println(futureD.join());
        System.out.println("总耗时:" + (System.currentTimeMillis() - start));
    }
}
