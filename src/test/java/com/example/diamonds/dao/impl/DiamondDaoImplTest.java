package com.example.diamonds.dao.impl;

import com.example.diamonds.dao.DiamondDao;
import com.example.diamonds.model.Diamond;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)

@SpringBootTest
class DiamondDaoImplTest {

    @Autowired
    private DiamondDao diamondDao;

    @BeforeEach
    void createTable() {
        diamondDao.createTableIfDoesNotExist();
    }

    @Test
    void testGetAll() {

        // Preparation
        int numberOfDiamonds = 10;

        for (int i = 0; i < numberOfDiamonds; i++){
            diamondDao.add(TestUtils.getNewDiamond());
        }

        // Action
        int result = diamondDao.getAll().size();

        // Result
        assertEquals(numberOfDiamonds, result);
    }

    @Test
    void testGetByCarat() {

        Diamond testDiamond = TestUtils.getNewDiamond();
        diamondDao.add(testDiamond);

        Diamond result = diamondDao.getByCarat(testDiamond.getCarat()).get(0);

        assertEquals(testDiamond, result);
    }

    @Test
    void testAdd() {

        diamondDao.add(TestUtils.getNewDiamond());

        int result = diamondDao.getAll().size();

        assertEquals(1, result);
    }

    @Test
    void testRemove() {

        Diamond testDiamond = TestUtils.getNewDiamond();

        diamondDao.add(testDiamond);

        assertEquals(1, diamondDao.getAll().size());

        diamondDao.remove(testDiamond);

        assertEquals(0, diamondDao.getAll().size());
    }
}