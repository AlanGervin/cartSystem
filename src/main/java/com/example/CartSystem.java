package com.example;

import java.util.HashMap;

public class CartSystem extends TheSystem {
    private HashMap<String, Item> cart;
	
    CartSystem() {
    	cart = new HashMap<>();
    }

    @Override
    public void display() {
    	double preTax = 0;
    	double tax = 0;
    	System.out.println("Cart:");
        System.out.printf("%-20s %-20s %-10s %-10s %-10s%n", "Name", "Description", "Price", "Quantity", "Sub Total");
        cart.forEach((string, item) -> { System.out.printf("%-20s %-20s %-10.2f %-10d %-10.2f%n", 
        		item.getItemName(), item.getItemDesc(),
        		item.getItemPrice(), item.getQuantity(), (item.getItemPrice() * item.getQuantity()));  	
        });
        for (String key: cart.keySet()) {
        	double preTotal = cart.get(key).getQuantity() * cart.get(key).getItemPrice();
        	preTax += preTotal;
        }   
        tax = preTax * 0.05;
//        cart
        System.out.printf("%-20s %-20.2f%n", "Pre-tax Total", preTax);
        System.out.printf("%-20s %-20.2f%n", "Tax", tax);
        System.out.printf("%-20s %-20.2f%n", "Total", tax+preTax);
    }
    

	public Boolean add(Item item) {
    	if (item == null) {
            return false;
        } else if ((cart.containsKey(item.getItemName()) 
        		&& (cart.get(item.getItemName()).getAvailableQuantity() >= 1))) {
            //Item we are going to replace with
        	Item tmpItem = cart.get(item.getItemName());
        	int quantity = tmpItem.getQuantity();
            tmpItem.setQuantity(quantity + 1);
            //System.out.println("executed");
        	cart.put(item.getItemName(), tmpItem);
            return true;
        } else if (cart.get(item.getItemName()) == null) {
        	//create an item with all the same properties as tmpItem but with a value of quantity of 1
        	Item itemToAdd = new Item(item.getItemName(), item.getItemDesc(),
        			item.getItemPrice(), 44);
        	itemToAdd.setQuantity(1);
        	cart.put(item.getItemName(), itemToAdd);
            return true;
        } else {
        	return false;
        }
    }
    
    @Override
    public Item remove(String itemName) {
        Item item = cart.get(itemName);
        if (item != null) {
        	cart.remove(itemName, item);
            System.out.println(itemName + " was removed from cart.");
            return item;
        }
        return null;
    }
}
