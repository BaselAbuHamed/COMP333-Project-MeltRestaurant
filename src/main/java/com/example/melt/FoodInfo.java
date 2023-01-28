package com.example.melt;

public class FoodInfo {
    private int foodInfoId;
    private String itemIngredients;

    public FoodInfo(){}

    public FoodInfo(int foodInfoId, String itemIngredients) {
        this.foodInfoId = foodInfoId;
        this.itemIngredients = itemIngredients;
    }

    public int getFoodInfoId() {
        return foodInfoId;
    }

    public void setFoodInfoId(int foodInfoId) {
        this.foodInfoId = foodInfoId;
    }

    public String getItemIngredients() {
        return itemIngredients;
    }

    public void setItemIngredients(String itemIngredients) {
        this.itemIngredients = itemIngredients;
    }

    @Override
    public String toString() {
        return "FoodInfo{" +
                "foodInfoId=" + foodInfoId +
                ", itemIngredients='" + itemIngredients + '\'' +
                '}';
    }
}
