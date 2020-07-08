package com.codevariant.awssqsspringboot.sqs;

import com.codevariant.awssqsspringboot.dto.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.aws.messaging.listener.Acknowledgment;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class SQSListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(SQSListener.class);


    @SqsListener(value = "${queue.name}", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
    public void listen(Order order, Acknowledgment acknowledgment, @Headers Map<String, String> headers)
            throws ExecutionException, InterruptedException {

        LOGGER.info("Recieved Message: order = {}, headers = {}", order, headers);

        /*
          process the message
          if processed successfully, delete from QUEUE
         */

        acknowledgment.acknowledge().get();
    }
}
