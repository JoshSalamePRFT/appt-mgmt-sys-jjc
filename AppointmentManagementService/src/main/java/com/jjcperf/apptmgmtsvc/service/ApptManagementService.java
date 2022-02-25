package com.jjcperf.apptmgmtsvc.service;

import com.jjcperf.apptmgmtsvc.model.Appointment;
import com.jjcperf.apptmgmtsvc.model.User;

import java.util.List;

public interface ApptManagementService {

    List<User> listUsers();
    List<Appointment> listAppts();

    List<Appointment> listApptsByUserId(long id);
    List<User> listUsersByApptId(long id);
}
