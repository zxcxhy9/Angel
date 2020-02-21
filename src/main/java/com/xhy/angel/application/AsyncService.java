package com.xhy.angel.application;

import com.xhy.angel.domain.LogstashKafkaMessage;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AsyncService {

    public CompletableFuture task1(LogstashKafkaMessage request) {
        CompletableFuture<LogstashKafkaMessage> future = CompletableFuture.supplyAsync(()->{
            try{
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LogstashKafkaMessage response = new LogstashKafkaMessage();
            response.setMsg("task1");
            return response;
        });
        return future;
    }

    public CompletableFuture task2(LogstashKafkaMessage request) {
        CompletableFuture<LogstashKafkaMessage> future = CompletableFuture.supplyAsync(()->{
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LogstashKafkaMessage response = new LogstashKafkaMessage();
            response.setMsg("task2");
            return response;
        });
        return future;
    }

    public CompletableFuture task3(LogstashKafkaMessage request) {
        CompletableFuture<LogstashKafkaMessage> future = CompletableFuture.supplyAsync(()->{
            try{
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LogstashKafkaMessage response = new LogstashKafkaMessage();
            response.setMsg("task3");
            return response;
        });

        return future;
    }
}
