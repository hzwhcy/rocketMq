package com.han.test;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

public class SyncProducer {

    public static void main(String[] args) throws Exception {

        DefaultMQProducer producer = new DefaultMQProducer("pg");
        producer.setNamesrvAddr("localhost:8080");
        producer.setRetryTimesWhenSendFailed(3);
        producer.setSendMsgTimeout(5000);
        producer.start();
        for (int i = 0; i < 100; i++) {
            byte[] body = ("hi " + i).getBytes(StandardCharsets.UTF_8);
            Message message = new Message("someTopic", "someTag", body);
            message.setKeys("key-" + i);
            SendResult result = producer.send(message);
            System.out.println(result);
        }
        producer.shutdown();
    }
}
