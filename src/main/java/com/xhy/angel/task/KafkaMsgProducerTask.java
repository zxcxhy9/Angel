package com.xhy.angel.task;

import com.xhy.angel.domain.LogstashKafkaMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Slf4j
@Component
@EnableScheduling
public class KafkaMsgProducerTask {

    private static Logger logger = LoggerFactory.getLogger(KafkaMsgProducerTask.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    //定时任务
    //@Scheduled(cron = "0/1 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    @Scheduled(fixedRate=1000)
    public void send() {
        Random r = new Random();
        int random = r.nextInt(100);
        for(int i = 0 ; i < random ; i++){
            LogstashKafkaMessage logstashKafkaMessage = new LogstashKafkaMessage();
            logstashKafkaMessage.setId(i);
            logstashKafkaMessage.setMsg(UUID.randomUUID().toString()+ "---" +i);
            logstashKafkaMessage.setSendTime(new Date());
            logger.info("发送消息 ----->>>>>  logstashKafkaMessage = {}", gson.toJson(logstashKafkaMessage));
            kafkaTemplate.send("test", gson.toJson(logstashKafkaMessage));
        }
    }
}
