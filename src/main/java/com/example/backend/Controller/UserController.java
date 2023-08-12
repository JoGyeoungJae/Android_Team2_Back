package com.example.backend.Controller;


import com.example.backend.Dto.User;
import com.example.backend.Response.ApiResponse;
import com.example.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/signup")
    public ResponseEntity<String> signUp( @RequestBody User user) {



        String uemail = user.getUemail();
        String upassword = user.getUpassword();
        String uname = user.getUname();
        String unickname = user.getUnickname();
        String uimg = user.getUimg();

        // 전송된 데이터를 로그에 출력하거나 원하는 처리를 수행합니다.
        System.out.println("Received data:");
        System.out.println("uemail: " + uemail);
        System.out.println("upassword: " + upassword);
        System.out.println("uname: " + uname);
        System.out.println("unickname: " + unickname);
        System.out.println("uimg: " + uimg);

        // 데이터베이스에 저장
        User newUser = new User();
        newUser.setUemail(uemail);
        newUser.setUpassword(upassword);
        newUser.setUname(uname);
        newUser.setUnickname(unickname);
        newUser.setUimg(uimg);


        userService.saveUser(newUser);



        return ResponseEntity.ok("ok!");

    }


    @RequestMapping("/login")
    public ResponseEntity<ApiResponse<User>> login(@RequestBody User user) {

        ApiResponse<User> response = new ApiResponse<>();

        String uemail = user.getUemail();
        String upassword = user.getUpassword();

        System.out.println("uemail: " + uemail);
        System.out.println("upassword: " + upassword);

        User existingUser = userService.getUserByUemail(uemail);


        if (existingUser == null) {
            System.out.println("그런 이메일 없다");
            response.setSuccess(false);
            response.setData(null);
            response.setError("No such email");
            return ResponseEntity.ok(response);
        }

        else if (existingUser !=null && !existingUser.getUpassword().equals(upassword)) {
            System.out.println("이메일은 맞는데 비밀번호가 틀렸다.");
            response.setSuccess(false);
            response.setData(null);
            response.setError("Incorrect password");
            return ResponseEntity.ok(response);
        }

        System.out.println("이메일과 비밀번호 일치! 아래에 유저정보 출력");
        System.out.println(existingUser);

        response.setSuccess(true);
        response.setData(existingUser);
        return ResponseEntity.ok(response);
    }












}