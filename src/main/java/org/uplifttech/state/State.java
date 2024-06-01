package org.uplifttech.state;

import org.uplifttech.controller.VendingMachine;
import org.uplifttech.model.Coin;
import org.uplifttech.model.Item;

import java.util.List;

public interface State {
    //list all methods which can be used in the VM
    public void clickOnInsertCoinButton(VendingMachine vm);
    public void insertCoin(VendingMachine vm, Coin coin);
    public int returnChange(int change);
    public void clickOnSelectItemButton(VendingMachine vm);
    public void selectItem(VendingMachine vm,int codeNumber);
    public Item dispenseItem(VendingMachine vm, int codeNumber);
    public List<Coin> refundAll(VendingMachine vm);
    public void updateInventory(VendingMachine vm,Item item, int codeNumber);

}
