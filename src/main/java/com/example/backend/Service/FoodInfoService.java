package com.example.backend.Service;

import com.example.backend.Entity.FoodInfo;
import com.example.backend.Repository.FoodInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodInfoService {

    @Autowired
    private FoodInfoRepository foodInfoRepository;

    public List<FoodInfo> findAll(){

        return foodInfoRepository.findAll();
    }
    public void save(FoodInfo foodInfo){
        foodInfoRepository.save(foodInfo);
    }

    public void delete(Long rid){
        foodInfoRepository.deleteById(rid);
    }
}
