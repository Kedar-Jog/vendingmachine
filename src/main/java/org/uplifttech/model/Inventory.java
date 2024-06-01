package org.uplifttech.model;

import lombok.Data;

@Data
public class Inventory {
    ItemShelf [] inventory = null;

    public Inventory(int itemCount) {
        inventory = new ItemShelf[itemCount];
        initializeEmptyInventory();
    }

    private void initializeEmptyInventory(){
        int startCode =101;
        for (int i = 0; i < inventory.length; i++) {
            ItemShelf space = ItemShelf.builder().code(startCode).soldOut(true).build();
            inventory[i] = space;
            startCode++;
        }
    }

    public void addItem(Item item, int code) {
        for(int i = 0; i < inventory.length; i++){
            if(inventory[i].code == code){
                if(inventory[i].isSoldOut()){
                    inventory[i].setItem(item);
                    inventory[i].setSoldOut(false);
                }
                else{
                    throw new RuntimeException("Item is available here, you can't add the same item");
                }
            }
        }
    }

    public Item getItem(int code) {
        for(int i = 0; i < inventory.length; i++){
            if(inventory[i].getCode() == code){
                if(!inventory[i].isSoldOut()){
                    return inventory[i].getItem();
                }
                else{
                    throw new RuntimeException("Item is not available here, you can't get the item");
                }
            }
        }
        return null;
    }


    public void updateSoldOutItem(int code){
        System.out.println("Marking as sold Out");
        for(int i = 0; i < inventory.length; i++){
            if(inventory[i].getCode() == code){
                inventory[i].setSoldOut(true);
            }
        }
    }


}
