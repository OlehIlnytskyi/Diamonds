package com.example.diamonds.service;

import com.example.diamonds.dao.DiamondDao;
import com.example.diamonds.model.Diamond;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiamondsService {

    private final DiamondDao diamondDao;

    public DiamondsService(DiamondDao diamondDao) {
        this.diamondDao = diamondDao;
    }


    public List<Diamond> getAllDiamonds() {
        return diamondDao.getAll();
    }

    public List<Diamond> getDiamondsByCarat(float carat) {
        return diamondDao.getByCarat(carat);
    }

    public Diamond addDiamond(Diamond diamond) {
        return diamondDao.add(diamond);
    }

    public Diamond removeDiamond(Diamond diamond) {
        return diamondDao.remove(diamond);
    }
}
