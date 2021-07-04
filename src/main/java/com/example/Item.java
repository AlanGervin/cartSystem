package com.example;

public class Item{
    private String itemName;
    private String itemDesc;
    private double itemPrice;
    private int quantity;
    private int availableQuantity;
    
    
    public Item() {
        this.availableQuantity = 1;
    }
    
    public Item(String itemName, String itemDesc, Double itemPrice, Integer availableQuantity) {
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.itemPrice = itemPrice;
        this.availableQuantity = availableQuantity;
    }
    
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getItemDesc() {
        return itemDesc;
    }
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
    public double getItemPrice() {
        return this.itemPrice;
    }
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getAvailableQuantity() {
        return availableQuantity;
    }
    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

}
