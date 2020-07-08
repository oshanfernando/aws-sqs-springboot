package com.codevariant.awssqsspringboot.sqs;

import com.codevariant.awssqsspringboot.dto.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.core.SqsMessageHeaders;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SQSPublisher {

    private static final Logger LOGGER = LoggerFactory.getLogger(SQSPublisher.class);

    @Autowired
    private QueueMessagingTemplate messagingTemplate;

    @Value("${queue.name}")
    String queueName;


    public void sendOrderStatus(Order order) {
        Map<String, Object> headers = new HashMap<>();
        headers.put(SqsMessageHeaders.SQS_GROUP_ID_HEADER, "group-1");

        LOGGER.info("Sending message : {}", order);

        messagingTemplate.convertAndSend(queueName, order, headers);
    }

}
