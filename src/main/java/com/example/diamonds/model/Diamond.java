package com.example.diamonds.model;

public record Diamond(
        float carat,
        String cut,
        String colour,
        String clarity,
        float depth,
        int table,
        int price,
        float x,
        float y,
        float z)
{
}
