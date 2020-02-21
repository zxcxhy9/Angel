package com.xhy.angel.domain;

import lombok.Data;

import java.util.Date;

@Data
public class LogstashKafkaMessage {

    public int id;

    public String msg;

    public Date sendTime;
}
