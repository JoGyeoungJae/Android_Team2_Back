package com.example.backend.Controller;

import com.example.backend.Entity.Comment;
import com.example.backend.Entity.FoodInfo;
import com.example.backend.Service.CommentService;
import com.example.backend.Service.FoodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    private final CommentService commentService;
    @Autowired
    FoodInfoService foodInfoService;
    @Autowired
    public CommentController(CommentService commentService) {this.commentService = commentService;}

    @RequestMapping("/comments")
    public ResponseEntity<String> postComment(@RequestBody Comment comment) {

        // 전송된 데이터를 로그에 출력하거나 원하는 처리를 수행합니다.
        System.out.println("Received data:");
        System.out.println("getCmt: " + comment.getCmt());
        System.out.println("getUid: " + comment.getUid());
        System.out.println("getId: " + comment.getId());
        System.out.println("getCmtTime: " + comment.getCmtTime());
        System.out.println("getNickname: " + comment.getNickname());
        System.out.println("getRid: " + comment.getRid());
        System.out.println("getStarpoint: " + comment.getStarpoint());
        Long rid = comment.getRid();
        Long rcount = foodInfoService.getonerest(rid).getRcount()+1;
        Long rtotalstar=foodInfoService.getonerest(rid).getRtotalstar()+comment.getStarpoint();
        Double rstaravg = (double) (rtotalstar/rcount);
        FoodInfo foodInfo = foodInfoService.getonerest(rid);
        foodInfo.setRcount(rcount);
        foodInfo.setRtotalstar(rtotalstar);
        foodInfo.setRstaravg(rstaravg);
        foodInfoService.save(foodInfo);


        commentService.saveComment(comment);


        return ResponseEntity.ok("ok!");
    }
    @GetMapping("/getReviewList")
    public List<Comment> findAllByUidAndRid(@RequestParam("uid") String uid,@RequestParam("rid") String rid) {
        //전체 리스트
        Long uuid =Long.valueOf(uid);
        Long rrid =Long.valueOf(rid);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+uid);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+rid);
        return commentService.findAllByUidAndRid(uuid,rrid);
    }

}