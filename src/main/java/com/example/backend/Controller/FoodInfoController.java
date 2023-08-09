package com.example.backend.Controller;

import com.example.backend.Entity.FoodInfo;
import com.example.backend.Service.FoodInfoService;
import com.example.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodInfoController {

    @Autowired
    FoodInfoService foodInfoService;

    @Autowired
    public FoodInfoController(FoodInfoService foodInfoService) {
        this.foodInfoService = foodInfoService;
    }


    @GetMapping("/foodfindAll")
    public List<FoodInfo> findAll() {

        return foodInfoService.findAll();
    }
    @PostMapping("/postFoodInfo")
    public void postFoodInfo(@RequestBody FoodInfo foodInfo){
        foodInfoService.save(foodInfo);
    }
}
