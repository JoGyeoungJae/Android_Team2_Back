package com.example.backend.Controller;

import com.example.backend.Entity.Comment;
import com.example.backend.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

//    @PostMapping("/signup")
//    public String signUp(@RequestBody SignupRequest request) {
//        String id = request.getId();
//        String password = request.getPassword();
//        String email = request.getEmail();
//        String phone = request.getPhone();
//
//        // 전송된 데이터를 로그에 출력하거나 원하는 처리를 수행합니다.
//        System.out.println("Received data:");
//        System.out.println("Id: " + id);
//        System.out.println("Password: " + password);
//        System.out.println("Email: " + email);
//        System.out.println("Phone: " + phone);
//
//        return "Data received successfully";
//    }


//    @RequestMapping("/hello")
//    public String hello() {
//        System.out.println("Received data:");
//        return "Hello REST!";
//    }

//    @PostMapping("/signup")


    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {this.commentService = commentService;}

    @RequestMapping("/comments")
    public String postComment( @RequestBody Comment comment) {

        String cmt = comment.getCmt();
        String cmtTime = comment.getCmtTime();
        String reviewimg = comment.getReviewimg();
        String uid = comment.getUid();

        // 전송된 데이터를 로그에 출력하거나 원하는 처리를 수행합니다.
        System.out.println("Received data:");
        System.out.println("cmt: " + cmt);
        System.out.println("cmtTime" + cmtTime);
        System.out.println("cmtTime" + reviewimg);
        System.out.println("uid" + uid);


        //db저장
        Comment comment1 = new Comment();
        comment1.setCmt(cmt);
        comment1.setCmtTime(cmtTime);
        comment1.setReviewimg(reviewimg);
        comment1.setUid(uid);


        commentService.saveComment(comment1);


        return "Data received successfully";
    }


}