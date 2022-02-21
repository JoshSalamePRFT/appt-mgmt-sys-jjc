package com.jjcperf.apptmgmtsvc.service;

import com.jjcperf.apptmgmtsvc.model.User;
import lombok.RequiredArgsConstructor;
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
