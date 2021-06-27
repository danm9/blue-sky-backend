package com.blueskyapp.BlueSkyProject.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blueskyapp.BlueSkyProject.model.BbHist;
import com.blueskyapp.BlueSkyProject.service.BbHistService;

@RestController
@RequestMapping("/bb_hist")
public class BbHistController {
    @Autowired
    BbHistService bbHistService;

    @GetMapping("")
    public List<BbHist> list() {
        return bbHistService.listAllBbHist();
    }

    @GetMapping("/{blueBucksId}")
    public ResponseEntity<BbHist> get(@PathVariable Integer blueBucksId) {
        try {
            BbHist bbHist = bbHistService.getBbHist(blueBucksId);
            return new ResponseEntity<BbHist>(bbHist, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<BbHist>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public void add(@RequestBody BbHist bbHist) {
        bbHistService.saveBbHist(bbHist);
    }
    @PutMapping("/{blueBucksId}")
    public ResponseEntity<?> update(@RequestBody BbHist bbHist, @PathVariable Integer blueBucksId) {
        try {
            BbHist existBbHist = bbHistService.getBbHist(blueBucksId);
            bbHist.setBlueBucksId(blueBucksId);
            bbHistService.saveBbHist(bbHist);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{blueBucksId}")
    public void delete(@PathVariable Integer blueBucksId) {

    	bbHistService.deleteBbHist(blueBucksId);
    }
	
}
