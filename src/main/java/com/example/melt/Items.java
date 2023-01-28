package com.example.melt;

public class Items {
    private int itemId;
    private String itemTitle;
    private double itemPrice;
    private int foodInfoId;
    private int menuId;

    public Items(){}

    public Items(int itemId, String itemTitle, double itemPrice, int foodInfoId, int menuId) {
        this.itemId = itemId;
        this.itemTitle = itemTitle;
        this.itemPrice = itemPrice;
        this.foodInfoId = foodInfoId;
        this.menuId = menuId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getFoodInfoId() {
        return foodInfoId;
    }

    public void setFoodInfoId(int foodInfoId) {
        this.foodInfoId = foodInfoId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemId=" + itemId +
                ", itemTitle='" + itemTitle + '\'' +
                ", itemPrice=" + itemPrice +
                ", foodInfoId=" + foodInfoId +
                ", menuId=" + menuId +
                '}';
    }
}

