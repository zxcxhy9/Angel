package com.xhy.angel.consumer;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    //@KafkaListener(topics = {"test"})
    //public void listen(ConsumerRecord<?, ?> record) {
      //  Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        //if (kafkaMessage.isPresent()) {
          //  Object message = kafkaMessage.get();
            //logger.info("----------------- record =" + record);
            //logger.info("------------------ message =" + message);
        //}
    //}
}
