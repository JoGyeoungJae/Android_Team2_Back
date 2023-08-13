package com.example.backend.Controller;

import com.example.backend.Entity.FoodInfo;
import com.example.backend.Service.FoodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    //전체 리스트
        return foodInfoService.findAll();
    }
    @PostMapping("/postFoodInfo")
    //인서트
    public void postFoodInfo(@RequestBody FoodInfo foodInfo){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(foodInfo.getRmainimg());
        foodInfoService.save(foodInfo);
    }

    @PostMapping("/postFoodInfodelete")
    public ResponseEntity<String> postFoodInfodelete(@RequestBody FoodInfo foodInfo){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(foodInfo.getRid());
        Long rid = foodInfo.getRid();
        foodInfoService.delete(rid);

        String message = "삭제되었습니다.";
        return ResponseEntity.ok(message);
    }
}
