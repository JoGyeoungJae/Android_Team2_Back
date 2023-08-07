package com.example.backend.Controller;

import com.example.backend.Dto.SignupRequest;
import com.example.backend.Dto.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @RequestMapping("/signup")
    public String signUp( @RequestBody User user) {
        String id = user.getId();
        String password = user.getPassword();
        String email = user.getEmail();
        String phone = user.getPhone();

        // 전송된 데이터를 로그에 출력하거나 원하는 처리를 수행합니다.
        System.out.println("Received data:");
        System.out.println("Received data:");
        System.out.println("Id: " + id);
        System.out.println("Password: " + password);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);

        return "Data received successfully";
    }


}