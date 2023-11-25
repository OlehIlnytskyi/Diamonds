package com.example.diamonds.dao.impl;

import com.example.diamonds.model.Diamond;

public class TestUtils {

    public static Diamond getNewDiamond() {
        return Diamond.builder()
                .carat(0.22f)
                .colour("J")
                .price(294)
                .build();
    }
}
