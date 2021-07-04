package com.example;

import java.util.HashMap;

public class AppSystem extends TheSystem {

	AppSystem() {

    }

    @Override
    public void display() {
        System.out.println("AppSystem Inventory:");
        HashMap<String, Item> itemList = this.getItemCollection();
        itemList.forEach((string, item) -> { System.out.printf("%-20s %-20s %-10.2f %-10d%n", 
        		item.getItemName(), item.getItemDesc(),
        		item.getItemPrice(), item.getAvailableQuantity()); });
    }

    @Override      // this overwrites the parents class add method 
    public Boolean add(Item item) {
    	HashMap<String, Item> system = this.getItemCollection();
    	if (item == null) {
            return false;
        } else if (system.get(item.getItemName()) != null && system.get(item.getItemName()).getAvailableQuantity() >= 1) {
        	Item tmpItem = system.get(item.getItemName());
        	//create an item with all the same properties as tmpItem but with a value of quantity of 1
        	//Item itemToAdd = new Item(tmpItem.getItemName(),tmpItem.getItemDesc(),tmpItem.getItemPrice(),1);
            int currentAvailable = tmpItem.getAvailableQuantity();
            tmpItem.setAvailableQuantity(currentAvailable + 1);
            system.put(item.getItemName(), tmpItem);
            this.setItemCollection(system);
            return true;
        } else if (system.get(item.getItemName()) == null) {
        
        	//create an item with all the same properties as tmpItem but with a value of quantity of 1
        	Item itemToAdd = new Item(item.getItemName(),item.getItemDesc(),item.getItemPrice(),1);
        	system.put(item.getItemName(), itemToAdd);
        	this.setItemCollection(system);
            return true;
        } else {
            return false;
        }
    }

    public Item reduceAvailableQuantity(String itemName) {
    	HashMap<String, Item> itemList = this.getItemCollection();
    	Item item = itemList.get(itemName);
    	int quantity = item.getAvailableQuantity();
    	item.setAvailableQuantity(quantity - 1);
    	itemList.put(itemName, item);
    	this.setItemCollection(itemList);
    	return item;
    }
}
