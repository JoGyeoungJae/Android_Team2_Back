package com.example.backend.Controller;


import com.example.backend.Dto.User;
import com.example.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String signUp( @RequestBody User user) {
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
        //연동테스트

        userService.saveUser(newUser);


        return "ok!";
    }


}