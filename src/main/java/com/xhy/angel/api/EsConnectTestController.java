package com.xhy.angel.api;

import com.google.gson.Gson;
import com.xhy.angel.domain.LogstashKafkaMessage;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class EsConnectTestController {
    @Resource
    private RestHighLevelClient restHighLevelClient;
    private String indexName = "logstash-kafka-2020.02.03";

    @RequestMapping(value = "EsConnectTest")
    public String hello() {

        Map<String, Object> query = new HashMap<>();

        try {
            LogstashKafkaMessage logstashKafkaMessage = new LogstashKafkaMessage();
            logstashKafkaMessage.setId(100);
            logstashKafkaMessage.setMsg(UUID.randomUUID().toString()+ "---" + 100 );
            logstashKafkaMessage.setSendTime(new Date());

            // 注意indexId是唯一的
            String indexId = "springboot + es + test001";
            add(logstashKafkaMessage, indexId);

            LogstashKafkaMessage logstashKafkaMessage2 = new LogstashKafkaMessage();
            logstashKafkaMessage2.setId(200);
            logstashKafkaMessage2.setMsg(UUID.randomUUID().toString()+ "---" + 200 );
            logstashKafkaMessage2.setSendTime(new Date());
            // 注意indexId是唯一的
            indexId = "springboot + es + test002";
            add(logstashKafkaMessage2, indexId);

            query = this.query("springboot + es + test002");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Hello World!" + query.toString();
    }

    private boolean add(LogstashKafkaMessage logstashKafkaMessage, String indexId) throws IOException {
        String json = new Gson().toJson(logstashKafkaMessage);
        IndexRequest request = new IndexRequest(indexName).id(indexId).source(json, XContentType.JSON);
        restHighLevelClient.index(request, RequestOptions.DEFAULT);

        return true;
    }

    private Map<String, Object> query(String indexId) throws IOException {
        GetRequest request = new GetRequest(indexName, indexId);
        GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);

        return response.getSource();
    }
}
