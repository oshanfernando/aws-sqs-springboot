package com.codevariant.awssqsspringboot.dto;

public class Order {

    public enum OrderStatusEnum {
        SUCCESS,
        FAILED
    }

    private int orderId;
    private int userId;
    private OrderStatusEnum orderStatus;

    public Order(int orderId, int userId, OrderStatusEnum orderStatus) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderStatus = orderStatus;
    }

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
