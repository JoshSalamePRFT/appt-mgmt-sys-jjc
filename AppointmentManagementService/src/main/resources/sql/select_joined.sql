select appointments.*
from users, appointments, users_appointments
where users.user_id = users_appointments.user_id
    and appointments.appointment_id = users_appointments.appointment_id
    and users.user_id = 11;

select appointments.appointment_id, appt_name, appt_type, description, end_time, meta_data, start_time
from users, appointments, users_appointments
where users.user_id = users_appointments.user_id
    and appointments.appointment_id = users_appointments.appointment_id;