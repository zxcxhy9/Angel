package com.xhy.angel.task;

import lombok.Data;

import java.util.Date;

@Data
public class Message {

    public int id;

    public String msg;

    public Date sendTime;
}
