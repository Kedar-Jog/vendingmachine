package org.uplifttech.state;

import org.uplifttech.controller.VendingMachine;
import org.uplifttech.model.Coin;
import org.uplifttech.model.Item;

import java.util.List;

public class DispenseState implements State {

    public DispenseState(VendingMachine vm,int codeNumber) {
        System.out.println("Dispensing");
        dispenseItem(vm,codeNumber);
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vm) {
        throw new RuntimeException("Can't do this operation in " + vm.getMachineState() + " in State");

    }

    @Override
    public void insertCoin(VendingMachine vm, Coin coin) {
        throw new RuntimeException("Can't do this operation in " + vm.getMachineState() + " in State");

    }

    @Override
    public int returnChange(int change) {
        throw new RuntimeException("Can't do this operation in ");
    }

    @Override
    public void clickOnSelectItemButton(VendingMachine vm) {
        throw new RuntimeException("Can't do this operation in " + vm.getMachineState() + " in State");

    }

    @Override
    public void selectItem(VendingMachine vm, int codeNumber) {
        throw new RuntimeException("Can't do this operation in " + vm.getMachineState() + " in State");

    }

    @Override
    public Item dispenseItem(VendingMachine vm, int codeNumber) {
        System.out.println("Dispensing the item " + codeNumber );
        Item item = vm.getInventory().getItem(codeNumber);
        vm.getInventory().updateSoldOutItem(codeNumber);
        vm.setMachineState(new Idle(vm));
        return item;
    }

    @Override
    public List<Coin> refundAll(VendingMachine vm) {
        throw new RuntimeException("Can't do this operation in " + vm.getMachineState() + " in State");

    }

    @Override
    public void updateInventory(VendingMachine vm, Item item, int codeNumber) {
        throw new RuntimeException("Can't do this operation in " + vm.getMachineState() + " in State");

    }
}
