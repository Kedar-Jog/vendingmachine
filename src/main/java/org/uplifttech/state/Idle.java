package org.uplifttech.state;

import org.uplifttech.controller.VendingMachine;
import org.uplifttech.model.Coin;
import org.uplifttech.model.Item;

import java.util.ArrayList;
import java.util.List;

public class Idle implements State{
    public Idle() {
        System.out.println("Vending Machine is in IDLE state");
    }

    public Idle(VendingMachine vendingMachine) {
        System.out.println("Vending Machine is in IDLE state");
        vendingMachine.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vm) {
        vm.setMachineState(new HasMoneyState());
    }

    @Override
    public void insertCoin(VendingMachine vm, Coin coin) {
        throw new RuntimeException("You cannot insert coins in IDLE state");
    }

    @Override
    public int returnChange(int change) {
        throw new RuntimeException("You cannot return change in IDLE state");
    }

    @Override
    public void clickOnSelectItemButton(VendingMachine vm) {
        throw new RuntimeException("Click insert coin first");

    }

    @Override
    public void selectItem(VendingMachine vm, int codeNumber) {
        throw new RuntimeException("You cannot select item in IDLE state");

    }

    @Override
    public Item dispenseItem(VendingMachine vm, int codeNumber) {
        throw new RuntimeException("You cannot dispense item in IDLE state");
    }

    @Override
    public List<Coin> refundAll(VendingMachine vm) {
        throw new RuntimeException("You cannot do refund in IDLE state");
    }

    @Override
    public void updateInventory(VendingMachine vm, Item item, int codeNumber) {

    }
}
