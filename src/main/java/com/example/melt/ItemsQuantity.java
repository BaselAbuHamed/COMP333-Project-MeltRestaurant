package com.example.melt;

public class ItemsQuantity {

    private String itemTitle;
    private int quantity;

    public ItemsQuantity(String itemTitle , int quantity){
        this.itemTitle=itemTitle;
        this.quantity=quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    @Override
    public String toString() {
        return "ItemsQuantity{" +
                "itemTitle='" + itemTitle + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
