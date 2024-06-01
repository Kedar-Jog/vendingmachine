package org.uplifttech.state;

import org.uplifttech.controller.VendingMachine;
import org.uplifttech.model.Coin;
import org.uplifttech.model.Item;

import java.util.List;

public class ProductSelectionState implements State{
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
        System.out.println("Returning change --> " + change);
        return change;
    }

    @Override
    public void clickOnSelectItemButton(VendingMachine vm) {
        throw new RuntimeException("Can't do this operation in " + vm.getMachineState() + " in State");

    }

    @Override
    public void selectItem(VendingMachine vm, int codeNumber) {
        Item item = vm.getInventory().getItem(codeNumber);
        int paidAmount = 0;
        for(Coin coin : vm.getCoinList()){
            paidAmount += coin.getValue();
        }

        if(paidAmount < item.getPrice()){
            System.out.println("Insufficient amount");
            refundAll(vm);
            throw new RuntimeException("Less amount paid");
        }
        else if(paidAmount >= item.getPrice()){
            returnChange(paidAmount - item.getPrice());
            vm.setMachineState(new DispenseState(vm,codeNumber));
        }

    }

    @Override
    public Item dispenseItem(VendingMachine vm, int codeNumber) {
        throw new RuntimeException("Can't do this operation in " + vm.getMachineState() + " in State");
    }

    @Override
    public List<Coin> refundAll(VendingMachine vm) {
        System.out.println("Refunding all");
        vm.setMachineState(new Idle(vm));
        return vm.getCoinList();
    }

    @Override
    public void updateInventory(VendingMachine vm, Item item, int codeNumber) {
        throw new RuntimeException("Can't do this operation in " + vm.getMachineState() + " in State");

    }
}
