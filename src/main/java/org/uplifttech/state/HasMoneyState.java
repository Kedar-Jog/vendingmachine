package org.uplifttech.state;

import org.uplifttech.controller.VendingMachine;
import org.uplifttech.model.Coin;
import org.uplifttech.model.Item;

import java.util.List;

public class HasMoneyState implements State{
    public HasMoneyState() {
        System.out.println("Vending Machine is in Has Money state");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vm) {
    return;
    }

    @Override
    public void insertCoin(VendingMachine vm, Coin coin) {
        System.out.println("Machine is accepting the coins");
        vm.getCoinList().add(coin);
    }

    @Override
    public int returnChange(int change) {
        return 0;
    }

    @Override
    public void clickOnSelectItemButton(VendingMachine vm) {
        vm.setMachineState(new ProductSelectionState());
    }

    @Override
    public void selectItem(VendingMachine vm, int codeNumber) {
        throw new RuntimeException("Not proper state");
    }

    @Override
    public Item dispenseItem(VendingMachine vm, int codeNumber) {
        return null;
    }

    @Override
    public List<Coin> refundAll(VendingMachine vm) {
        return List.of();
    }

    @Override
    public void updateInventory(VendingMachine vm, Item item, int codeNumber) {
        vm.getInventory().addItem(item,codeNumber);
    }
}
