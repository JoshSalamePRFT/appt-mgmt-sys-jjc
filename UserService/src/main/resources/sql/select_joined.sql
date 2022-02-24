select users_appointments.*,
       users.first_name, users.last_name,
       appointments.appt_name, appointments.start_time, appointments.end_time
from users, appointments, users_appointments
where users.user_id = users_appointments.user_id
and appointments.appointment_id = users_appointments.appointment_id
order by user_id;