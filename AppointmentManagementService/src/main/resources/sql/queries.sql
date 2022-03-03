use appt_mgmt_sys;

select * from users_appointments;

# Select appointments based on user_id = 1.
select appointments.*
from users, appointments, users_appointments
where users.user_id = users_appointments.user_id
  and appointments.appointment_id = users_appointments.appointment_id
  and users.user_id = 1;

# Select appointment info for all non-empty appointments (has a user RSVPed, and is therefore in the join table).
select appointments.appointment_id, appt_name, appt_type, description, end_time, meta_data, start_time
from users, appointments, users_appointments
where users.user_id = users_appointments.user_id
  and appointments.appointment_id = users_appointments.appointment_id;

drop table users_appointments;