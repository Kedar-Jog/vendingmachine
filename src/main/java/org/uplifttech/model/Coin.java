package org.uplifttech.model;


public enum Coin {
    RUPEE_1(1),
    RUPEE_5(5),
    RUPEE_10(10),
    RUPEE_20(20),
    RUPEE_50(50),
    RUPEE_100(100),
    RUPEE_200(200),
    RUPEE_500(500);

        final int value;
        Coin(int value) {this.value = value;}

        public int getValue() {
            return value;
        }

}
