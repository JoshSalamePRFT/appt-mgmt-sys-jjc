package com.example.apptmgmtsvc.service;

import com.example.apptmgmtsvc.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ApptManagementServiceImpl implements ApptManagementService {


    @Override
    public List<User> listUsers() {
        return null;
    }
}
