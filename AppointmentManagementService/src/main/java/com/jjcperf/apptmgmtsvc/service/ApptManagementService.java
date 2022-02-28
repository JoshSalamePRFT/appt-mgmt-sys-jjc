package com.jjcperf.apptmgmtsvc.service;

import com.jjcperf.apptmgmtsvc.model.Appointment;
import com.jjcperf.apptmgmtsvc.model.User;

import javax.jms.JMSException;
import java.util.List;

public interface ApptManagementService {

    List<User> listUsers() throws JMSException;
    List<Appointment> listAppts();

    List<Appointment> listApptsByUserId(long id);
    List<User> listUsersByApptId(long id);
}
