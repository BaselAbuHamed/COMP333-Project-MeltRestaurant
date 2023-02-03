package com.example.melt;

public class OrderItems {

    private int orderId;
    private int itemId;
    private int quantity;
    private double totalPrice;

    public OrderItems(int orderId, int itemId, int quantity, double totalPrice){
        this.orderId=orderId;
        this.itemId=itemId;
        this.quantity=quantity;
        this.totalPrice=totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
