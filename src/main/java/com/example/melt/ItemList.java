package com.example.melt;

public class ItemList {
    private int menuId;
    private String menuTitle;

    public ItemList(){}

    public ItemList(int menuId, String menuTitle) {
        this.menuId = menuId;
        this.menuTitle = menuTitle;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    @Override
    public String toString() {
        return "ItemList{" +
                "menuId=" + menuId +
                ", menuTitle='" + menuTitle + '\'' +
                '}';
    }
}
