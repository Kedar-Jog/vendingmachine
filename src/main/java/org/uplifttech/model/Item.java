package org.uplifttech.model;

import lombok.Data;

@Data
public class Item {
    private ItemType itemType;
    private int price;

    public Item() {
    }

    public Item(ItemType itemType, int price) {
        this.itemType = itemType;
        this.price = price;
    }


}
