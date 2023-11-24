package com.example.diamonds.dao;

import com.example.diamonds.model.Diamond;

import java.util.List;

public interface DiamondDao {
    List<Diamond> getAll();

    List<Diamond> getByCarat(float carat);

    Diamond add(Diamond diamond);

    Diamond remove(Diamond diamond);

    void createTableIfDoesNotExist();
}
