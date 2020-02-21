package com.xhy.angel;

import com.xhy.angel.application.AsyncService;
import com.xhy.angel.domain.LogstashKafkaMessage;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class AsyncServiceTest {

    public static void main(String[] args) {

        Long time = System.currentTimeMillis();
        AsyncService asyncService = new AsyncService();

        LogstashKafkaMessage logstashKafkaMessage = new LogstashKafkaMessage();
        CompletableFuture futureA = asyncService.task1(logstashKafkaMessage);
        CompletableFuture futureB = asyncService.task2(logstashKafkaMessage);
        CompletableFuture futureC = asyncService.task3(logstashKafkaMessage);

        //CompletableFuture all = CompletableFuture.allOf(futureA, futureB, futureC);
        //all.join();


        final CompletableFuture responseFutureA = within(
                futureA, Duration.ofSeconds(1));


        responseFutureA
                .thenAccept((a) -> {System.out.println(a.toString());})
                .exceptionally(throwable -> {
                    System.out.println(throwable.toString());
                    return null;
                });


        final CompletableFuture responseFutureB = within(
                futureB, Duration.ofSeconds(1));


        responseFutureB
                .thenAccept((a) -> {System.out.println(a.toString());})
                .exceptionally(throwable -> {
                    System.out.println(throwable.toString());
                    return null;
                });


        final CompletableFuture responseFutureC = within(
                futureC, Duration.ofSeconds(1));


        responseFutureC
                .thenAccept((a) -> {
                    System.out.println(a.toString());
                })
                .exceptionally(throwable -> {
                    System.out.println(throwable.toString());
                    return null;
                });


        //CompletableFuture all = CompletableFuture.allOf(responseFutureA, responseFutureB, responseFutureC);
        //all.join();

        Long endTime = System.currentTimeMillis();
        System.out.println("用时：" + (endTime - time));


    }

    public static <T> CompletableFuture<T> within(CompletableFuture<T> future, Duration duration) {
        final CompletableFuture<T> timeout = failAfter(duration);
        return future.applyToEither(timeout, Function.identity());
    }

    public static <T> CompletableFuture<T> failAfter(Duration duration) {
        final CompletableFuture<T> promise = new CompletableFuture<>();
        scheduler.schedule(() -> {
            final TimeoutException ex = new TimeoutException("Timeout after " + duration);
            return promise.completeExceptionally(ex);
        }, duration.toMillis(), MILLISECONDS);
        return promise;
    }

    private static final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(
                    1);
}
