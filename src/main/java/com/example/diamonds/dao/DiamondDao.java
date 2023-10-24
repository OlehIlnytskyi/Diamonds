package com.example.diamonds.dao;

import com.example.diamonds.model.Diamond;

import java.util.List;

public interface DiamondDao {
    List<Diamond> getAll();

    List<Diamond> getByCarat(float carat);

    List<Diamond> getSortedBy(String sortedBy, String dir);

    Diamond add(Diamond diamond);

    Diamond remove(Diamond diamond);
}
