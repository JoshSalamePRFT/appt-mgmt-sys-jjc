package com.example.apptmgmtsvc.web.controller;

import com.example.apptmgmtsvc.model.User;
import com.example.apptmgmtsvc.service.ApptManagementService;
import com.example.apptmgmtsvc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/mgr")
@RequiredArgsConstructor
public class ApptMgrController {

    @Autowired
    private final ApptManagementService apptManagementService;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/getusers")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() {
        return null;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<String> validationError(MethodArgumentNotValidException ex) {
        List<String> exceptions = new ArrayList<>();

        ex.getFieldErrors().forEach(fieldError -> {
            exceptions.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
        });
        return exceptions;
    }
}
