package com.example.diamonds.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Diamond {
    private float carat;
    private String cut;
    private String colour;
    private String clarity;
    private float depth;
    private int table;
    private int price;
    private float x;
    private float y;
    private float z;
}
