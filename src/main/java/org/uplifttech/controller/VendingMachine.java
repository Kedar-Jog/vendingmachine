package org.uplifttech.controller;

import lombok.Data;
import org.uplifttech.model.Coin;
import org.uplifttech.model.Inventory;
import org.uplifttech.state.Idle;
import org.uplifttech.state.State;

import java.util.ArrayList;
import java.util.List;

@Data
public class VendingMachine {
    private State machineState;
    private Inventory inventory;
    private List<Coin> coinList;

    public VendingMachine() {
        this.machineState = new Idle();
        this.inventory = new Inventory(10);
        this.coinList = new ArrayList<>();
    }
}
