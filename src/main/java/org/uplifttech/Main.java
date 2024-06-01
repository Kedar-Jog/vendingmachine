package org.uplifttech;

import org.uplifttech.controller.VendingMachine;
import org.uplifttech.model.Coin;
import org.uplifttech.model.Item;
import org.uplifttech.model.ItemShelf;
import org.uplifttech.model.ItemType;
import org.uplifttech.state.State;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome! This is vending machine !!");
        VendingMachine vendingMachine = new VendingMachine();
        try {
            System.out.println("|");
            System.out.println("Adding inventory");
            System.out.println("|");
            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);
            System.out.println("|");
            System.out.println("Clicking on insert coin button");
            System.out.println("|");

            State currentState = vendingMachine.getMachineState();
            currentState.clickOnInsertCoinButton(vendingMachine);

            currentState = vendingMachine.getMachineState();
            currentState.insertCoin(vendingMachine, Coin.RUPEE_20);
            System.out.println("|");
            System.out.println("Clicking on selection button");
            System.out.println("|");

            currentState = vendingMachine.getMachineState();
            currentState.clickOnSelectItemButton(vendingMachine);

            System.out.println("|");
            System.out.println("selecting item");
            System.out.println("|");

            currentState = vendingMachine.getMachineState();
            currentState.selectItem(vendingMachine,102);

            currentState = vendingMachine.getMachineState();

            System.out.println("|");
            System.out.println("dispensing item");
            System.out.println("|");
//            currentState.dispenseItem(vendingMachine,102);

            displayInventory(vendingMachine);

        }catch (Exception e) {
          e.printStackTrace();
//            displayInventory(vendingMachine);
        }finally {

        }

    }

    private static void fillUpInventory(VendingMachine vendingMachine){
        System.out.println("Filling inventory");
        ItemShelf [] slots = vendingMachine.getInventory().getInventory();
        for(int i=0; i<slots.length; i++){
            Item newItem = new Item();
            if(i >= 0 && i< 3){
                newItem.setItemType(ItemType.COKE);
                newItem.setPrice(20);
            }else if(i>2 && i<5){
                newItem.setItemType(ItemType.PEPSI);
                newItem.setPrice(30);
            }else if(i>4 && i<7){
                newItem.setItemType(ItemType.FANTA);
                newItem.setPrice(40);
            }else{
                newItem.setItemType(ItemType.WATER);
                newItem.setPrice(20);
            }
            slots[i].setItem(newItem);
            slots[i].setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine){
        ItemShelf [] slots = vendingMachine.getInventory().getInventory();
        for(int i=0; i< slots.length; i++){
            System.out.println("CodeNumber: " + slots[i].getCode() + " Item: " + slots[i].getItem().getItemType().name()
            + " Price: "+ slots[i].getItem().getPrice() + " isAvailable: " + !slots[i].isSoldOut());
        }
    }
}