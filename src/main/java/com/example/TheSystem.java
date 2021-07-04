package com.example;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public abstract class TheSystem {
    private HashMap<String, Item> itemCollection;
   

    TheSystem() {
    	itemCollection = new HashMap<>();
        if (getClass().getSimpleName().equals("AppSystem")) {    
            File file = new File("resources\\sample.txt");
            try { 
                Scanner in = new Scanner(file);

                while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] itemInfo = line.split("  ");
                itemCollection.put(itemInfo[0], new Item(itemInfo[0], itemInfo[1],
                         Double.parseDouble(itemInfo[2]), Integer.parseInt(itemInfo[3])));
             }

             in.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public HashMap<String, Item> getItemCollection(){
        return itemCollection;
    }
    
    public void setItemCollection(HashMap<String, Item> mapp) {
        this.itemCollection = mapp;
    }
    
    public Boolean checkAvailability(Item item) {
        if (item.getQuantity() >= item.getAvailableQuantity()) {
            System.out.println("System is unable to add " + item.getItemName() + " to the card. System only has " + itemCollection.get(item.getItemName()).getAvailableQuantity() + " " + item.getItemName()+"s.");
            return false;
        } else {
            return true;
        }
    }
    
    public Boolean add(Item item) {
        if (item == null) {
            return false;
        } else if ((itemCollection.get(item.getItemName()) != null) && (item.getAvailableQuantity() >= 1)) {
            Item tmpItem = itemCollection.get(item.getItemName());
            int currentAvailable = tmpItem.getAvailableQuantity();
            tmpItem.setAvailableQuantity(currentAvailable + 1);
            itemCollection.put(item.getItemName(), tmpItem);
            this.setItemCollection(itemCollection);
            return true;
        } else if (itemCollection.get(item.getItemName()) == null) {
            itemCollection.put(item.getItemName(), item);
            return true;
        } else {
            return false;
        }
    }

    public Item remove(String itemName) {
    	
    	if (itemCollection.containsKey(itemName)) {
	        Item item = itemCollection.get(itemName);
            itemCollection.remove(itemName);
            return item;
    	} else {
            return null;
        }
    }

    public abstract void display();
}
