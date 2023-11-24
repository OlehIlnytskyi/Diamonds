package com.example.diamonds.dao.impl;

import com.example.diamonds.model.Diamond;

public class TestUtils {

    public static Diamond getNewDiamond() {
        return Diamond.builder()
                .carat(0.22f)
                .cut("Very Good")
                .colour("J")
                .clarity("SI1")
                .depth(58.1f)
                .table(49)
                .price(294)
                .x(4.07f)
                .y(4.11f)
                .z(2.53f)
                .build();
    }
}
