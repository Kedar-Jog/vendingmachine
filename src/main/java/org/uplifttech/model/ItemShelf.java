package org.uplifttech.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemShelf {
    int code;
    Item item;
    boolean soldOut;
}
