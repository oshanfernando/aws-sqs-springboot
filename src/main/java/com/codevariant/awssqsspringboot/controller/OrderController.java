package com.codevariant.awssqsspringboot.controller;

import com.codevariant.awssqsspringboot.dto.Order;
import com.codevariant.awssqsspringboot.sqs.SQSPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private SQSPublisher sqsPublisher;

    @GetMapping("/sendstatus")
    public ResponseEntity<Object> sendStatus(@RequestParam("orderid") Integer orderId,
                                             @RequestParam("userid") Integer userId,
                                             @RequestParam("orderstatus") Order.OrderStatusEnum orderStatus) {

        sqsPublisher.sendOrderStatus(new Order(orderId, userId, orderStatus));

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
