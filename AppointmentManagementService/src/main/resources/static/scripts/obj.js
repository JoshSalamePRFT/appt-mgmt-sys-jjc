class User {
    user_id;
    firstName;
    lastName;
    gender;
    age;
    emailAddress;
    phoneNumber;

    constructor(json) {
        this.user_id = json.user_id;
        this.firstName = json.firstName;
        this.lastName = json.lastName;
        this.gender = json.gender;
        this.age = json.age;
        this.emailAddress = json.emailAddress;
        this.phoneNumber = json.phoneNumber;
    }

    toString() {
        return `${this.user_id} ${this.firstName} ${this.lastName}`;
    }

    toTableRow(edit = false, deleteUser = false) {
        let tr = [];
        tr.push(`<tr id=${this.user_id}>`);
        tr.push(`<td>${this.user_id}</td>`);
        tr.push(`<td>${this.firstName}</td>`);
        tr.push(`<td>${this.lastName}</td>`);
        tr.push(`<td>${this.gender}</td>`);
        tr.push(`<td>${this.age}</td>`);
        tr.push(`<td>${this.emailAddress}</td>`);
        tr.push(`<td>${this.phoneNumber}</td>`);
        tr.push(`<td>`);
        if (edit) {
            tr.push(`<button class='edit-user' value=${this.user_id}>Edit</button>`);
        }
        if (deleteUser) {
            tr.push(`<button class='delete-user' value=${this.user_id}>Delete</button>`);
        }
        tr.push(`</td>`);
        tr.push(`</tr>`);
        return tr.join('');
    }

    toJSON() {
        return JSON.stringify({
            'user_id': this.user_id,
            'firstName': this.firstName,
            'lastName': this.lastName,
            'gender': this.gender,
            'age': this.age,
            'emailAddress': this.emailAddress,
            'phoneNumber': this.phoneNumber,
        });
    }
}

class Appointment {
    appointment_id;
    apptName;
    apptType;
    description;
    startTime;
    endTime;
    metaData;

    constructor(json) {
        this.appointment_id = json.appointment_id;
        this.apptName = json.apptName;
        this.apptType = json.apptType;
        this.description = json.description;
        // this.startTime = json.startTime.split('T')[1]; //only shows time, not date
        // this.endTime = json.endTime.split('T')[1]; //only shows time, not date
        this.startTime = json.startTime;
        this.endTime = json.endTime;
        this.metaData = json.metaData;
    }

    toString() {
        return `${this.appointment_id} ${this.apptName} ${this.startTime} ${this.endTime}`;
    }

    toTableRow(edit = false, unRSVP = false,  invite = false, rsvp = false,  deleteAppt = false) {
        let tr = [];
        tr.push(`<tr id=${this.appointment_id}>`);
        tr.push(`<td>${this.appointment_id}</td>`);
        tr.push(`<td>${this.apptName}</td>`);
        tr.push(`<td>${this.apptType}</td>`);
        tr.push(`<td>${this.description}</td>`);
        tr.push(`<td>${this.startTime}</td>`);
        tr.push(`<td>${this.endTime}</td>`);
        tr.push(`<td>${this.metaData}</td>`);
        tr.push(`<td>`);
        if (edit) {
            tr.push(`<button class='edit-appt' value=${this.appointment_id}>Edit</button>`);
        }
        if (unRSVP) {
            tr.push(`<button class='unrsvp-appt' value=${this.appointment_id}>UnRSVP</button>`);
        }
        if (invite) {
            tr.push(`<button class='invite-appt' value=${this.appointment_id}>Invite</button>`);
        }
        if (rsvp) {
            tr.push(`<button class='rsvp-appt' value=${this.appointment_id}>RSVP</button>`);
        }
        if (deleteAppt) {
            tr.push(`<button class='delete-appt' value=${this.appointment_id}>Delete</button>`);
        }
        tr.push(`</td>`);
        tr.push(`</tr>`);
        return tr.join('');
    }

    toJSON() {
        return JSON.stringify({
            'appointment_id': this.appointment_id,
            'apptName': this.apptName,
            'apptType': this.apptType,
            'description': this.description,
            'startTime': this.startTime,
            'endTime': this.endTime,
            'metaData': this.metaData,
        });
    }
}