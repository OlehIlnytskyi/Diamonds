package com.example.diamonds.controller;

import com.example.diamonds.model.Diamond;
import com.example.diamonds.service.DiamondsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diamonds")
public class DiamondsController {

    private final DiamondsService diamondsService;

    public DiamondsController(DiamondsService diamondsService) {
        this.diamondsService = diamondsService;
    }

    @GetMapping
    public List<Diamond> getAllDiamonds() {
        return diamondsService.getAllDiamonds();
    }

    @GetMapping("/get")
    public List<Diamond> getDiamondsByCarat(@RequestParam float carat) {
        return diamondsService.getDiamondsByCarat(carat);
    }

    @GetMapping("/get-sorted-by")
    public List<Diamond> getDiamondsSortedBy(@RequestParam String sortedBy, @RequestParam String dir) {
        return diamondsService.getDiamondsSortedBy(sortedBy, dir);
    }

    @PostMapping("/post")
    public Diamond addDiamond(@RequestBody Diamond diamond) {
        return diamondsService.addDiamond(diamond);
    }

    @DeleteMapping("/delete")
    public Diamond removeDiamond(@RequestBody Diamond diamond) {
        return diamondsService.removeDiamond(diamond);
    }
}
