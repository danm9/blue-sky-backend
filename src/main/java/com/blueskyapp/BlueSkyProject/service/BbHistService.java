package com.blueskyapp.BlueSkyProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blueskyapp.BlueSkyProject.model.BbHist;
import com.blueskyapp.BlueSkyProject.repository.BbHistRepository;

import java.util.List;
import javax.transaction.Transactional;
@Service
@Transactional
public class BbHistService {
    @Autowired
    private BbHistRepository bbHistRepository;
    public List<BbHist> listAllBbHist() {
        return bbHistRepository.findAll();
    }

    public void saveBbHist(BbHist bbHist) {
    	bbHistRepository.save(bbHist);
    }

    public BbHist getBbHist(Integer blueBucksId) {
        return bbHistRepository.findById(blueBucksId).get();
    }

    public void deleteBbHist(Integer blueBucksId) {
    	bbHistRepository.deleteById(blueBucksId);
    }
}
