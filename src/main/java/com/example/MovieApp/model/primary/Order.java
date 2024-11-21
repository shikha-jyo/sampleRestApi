package com.example.MovieApp.model.primary;

import java.sql.Time;

public class Order {

private long orderId;
private Time timestamp;

public Order(long orderId,Time timestamp){
    this.orderId = orderId;
    this.timestamp = timestamp;
}

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", timestamp=" + timestamp +
                '}';
    }

    public long getOrderId() {
        return orderId;
    }

    public Time getTimestamp() {
        return timestamp;
    }
}
