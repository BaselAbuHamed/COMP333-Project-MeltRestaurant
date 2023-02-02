package com.example.melt;

public class NewOrder {
    private int itemId;
    private String Title;
    private Double price;
    private int quantity;

    public NewOrder() {

    }

    public NewOrder(String title, Double price, int quantity,int itemId) {
        Title = title;
        this.price = price;
        this.quantity = quantity;
        this.itemId=itemId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "NewOrder{" +
                "Title='" + Title + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
