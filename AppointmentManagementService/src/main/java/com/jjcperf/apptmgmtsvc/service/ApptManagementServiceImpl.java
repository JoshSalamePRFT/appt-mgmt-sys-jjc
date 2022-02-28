package com.jjcperf.apptmgmtsvc.service;

import com.jjcperf.apptmgmtsvc.model.Appointment;
import com.jjcperf.apptmgmtsvc.model.User;
import com.jjcperf.msg.sender.MgmtSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.jms.Message;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ApptManagementServiceImpl implements ApptManagementService {

    MgmtSender mgmtSender;

    @Override
    public List<User> listUsers() {


        Message message = mgmtSender.sendUserGetAllMessage();
        return null;
    }

    @Override
    public List<Appointment> listAppts() {
        return null;
        //mgmtSender.sendApptGetAllMessage();
        //mgmtListener.listenForApptSvc();
    }

    @Override
    public List<Appointment> listApptsByUserId(long id) {
        return null;
    }

    @Override
    public List<User> listUsersByApptId(long id) {
        return null;
    }
}
