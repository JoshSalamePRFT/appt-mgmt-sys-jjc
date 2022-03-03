package com.jjcperf.apptmgmtsvc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjcperf.apptmgmtsvc.model.Appointment;
//import com.jjcperf.apptmgmtsvc.model.Wrapper;
import com.jjcperf.apptmgmtsvc.model.AppointmentDTO;
import com.jjcperf.apptmgmtsvc.model.User;
//import com.jjcperf.apptmgmtsvc.repository.ApptAndUserRepository;
import com.jjcperf.apptmgmtsvc.model.UserDTO;
import com.jjcperf.apptmgmtsvc.repository.ApptRepository;
import com.jjcperf.apptmgmtsvc.repository.UserRepository;
import com.jjcperf.apptmgmtsvc.web.mappers.ApptMapperImpl;
import com.jjcperf.apptmgmtsvc.web.mappers.UserMapperImpl;
import com.jjcperf.msg.msg.ResponseMessage;
import com.jjcperf.msg.sender.MgmtSenderAndReceiver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.persistence.EntityManager;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApptManagementServiceImpl implements ApptManagementService {

    @Autowired
    MgmtSenderAndReceiver mgmtSenderAndReceiver;

    @Autowired
    ApptRepository apptRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager entityManager;

    ObjectMapper mapper;
    UserMapperImpl userMapper;
    ApptMapperImpl apptMapper;
    public ApptManagementServiceImpl() {
        mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        userMapper = new UserMapperImpl();
        apptMapper = new ApptMapperImpl();
    }


    //TODO implement methods

    @Override
    public List<Appointment> listApptsByUserId(long user_id) {
        //retrieve list of appointment ids from database
        List<Long> appointment_idList = userRepository.getAppointmentsByUserId(user_id);

        List<Appointment> appointmentList = new ArrayList<>();

        //retrieve appointment entries by id for each id in the list.
        appointment_idList.forEach(appointment_id -> {
            try {
                appointmentList.add(readAppointment(appointment_id));
            } catch (JMSException e) {
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        return appointmentList;
    }

    @Override
    public List<User> listUsersByApptId(long appointment_id) {
        //retrieve list of user ids from database
        List<Long> user_idList = apptRepository.getUsersByAppointmentId(appointment_id);

        List<User> userList = new ArrayList<>();

        //retrieve appointment entries by id for each id in the list.
        user_idList.forEach(user_id -> {
            try {
                userList.add(readUser(user_id));
            } catch (JMSException e) {
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        return userList;
    }

    //same thing as addApptToUser, both should just add an entry to the join table. Only implementing this version.
    //TODO maybe add some sort of success response. Could do in the controller instead, just "Success" if no error was thrown.
    @Override
    public void addUserToAppt(long user_id, long appt_id) {
        userRepository.addUserToAppointment(user_id, appt_id);
    }


    //CRUD FOR USER & APPT
    //TODO code cleanup

    @Override
    public List<User> listUsers() throws JMSException, JsonProcessingException {
        //Conversion from Message to String to ResponseMessage to List
        String message = mgmtSenderAndReceiver.sendUserGetAllMessage().getBody(String.class);
        ResponseMessage responseMessage = mapper.readValue(message, ResponseMessage.class);
        return responseMessage.getEntities();
    }

    @Override
    public List<Appointment> listAppts() throws JMSException, JsonProcessingException {
        //Conversion from Message to String to ResponseMessage to List
        String message = mgmtSenderAndReceiver.sendAppointmentGetAllMessage().getBody(String.class);
        ResponseMessage responseMessage = mapper.readValue(message, ResponseMessage.class);
        return responseMessage.getEntities();
    }

    @Override
    public User readUser(long user_id) throws JMSException, JsonProcessingException {
        String message = mgmtSenderAndReceiver.sendUserGetMessage(user_id).getBody(String.class);
        ResponseMessage responseMessage = mapper.readValue(message, ResponseMessage.class);
        return (User) responseMessage.getEntities().get(0);
    }

    @Override
    public User readUserByEmailAddress(String emailAddress) throws JMSException, JsonProcessingException {
        String message = mgmtSenderAndReceiver.sendUserGetByEmailMessage(emailAddress).getBody(String.class);
        ResponseMessage responseMessage = mapper.readValue(message, ResponseMessage.class);
        return (User) responseMessage.getEntities().get(0);
    }

    @Override
    public Appointment readAppointment(long appt_id) throws JMSException, JsonProcessingException {
        String message = mgmtSenderAndReceiver.sendAppointmentGetMessage(appt_id).getBody(String.class);
        ResponseMessage responseMessage = mapper.readValue(message, ResponseMessage.class);
        return (Appointment) responseMessage.getEntities().get(0);
    }

    @Override
    public User createUser(UserDTO dto) throws JsonProcessingException, JMSException {
        User user = userMapper.dtoToUser(dto);
        System.out.println(user);
        String message = mgmtSenderAndReceiver.sendUserPostMessage(user).getBody(String.class);
        ResponseMessage responseMessage = mapper.readValue(message, ResponseMessage.class);
        return (User) responseMessage.getEntities().get(0);
    }

    @Override
    public Appointment createAppointment(AppointmentDTO dto) throws JMSException, JsonProcessingException {
        Appointment appt = apptMapper.dtoToAppt(dto);
        System.out.println(appt);
        String message = mgmtSenderAndReceiver.sendAppointmentPostMessage(appt).getBody(String.class);
        ResponseMessage responseMessage = mapper.readValue(message, ResponseMessage.class);
        return (Appointment) responseMessage.getEntities().get(0);
    }

    @Override
    public User updateUser(long user_id, User user) throws JMSException, JsonProcessingException {
        String message = mgmtSenderAndReceiver.sendUserPutMessage(user_id, user).getBody(String.class);
        ResponseMessage responseMessage = mapper.readValue(message, ResponseMessage.class);
        return (User) responseMessage.getEntities().get(0);
    }

    @Override
    public Appointment updateAppointment(long appt_id, Appointment appointment) throws JMSException, JsonProcessingException {
        String message = mgmtSenderAndReceiver.sendAppointmentPutMessage(appt_id, appointment).getBody(String.class);
        ResponseMessage responseMessage = mapper.readValue(message, ResponseMessage.class);
        return (Appointment) responseMessage.getEntities().get(0);
    }

    @Override
    public void deleteUser(long user_id) {
        mgmtSenderAndReceiver.sendUserDeleteMessage(user_id);
    }

    @Override
    public void deleteAppointment(long appt_id) {
        mgmtSenderAndReceiver.sendAppointmentDeleteMessage(appt_id);
    }


}
