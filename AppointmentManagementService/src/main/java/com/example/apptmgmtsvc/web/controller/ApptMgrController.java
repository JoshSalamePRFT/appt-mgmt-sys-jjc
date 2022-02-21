package com.example.apptmgmtsvc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/mgr")
@RequiredArgsConstructor
public class ApptMgrController {


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

//    @GetMapping("/getuser/{user_id}")
//    @ResponseStatus(HttpStatus.OK)
//    public UserDTO getUserDTO(@PathVariable("user_id") long user_id) {
//        return userService.readUser(user_id);
//    }

}
