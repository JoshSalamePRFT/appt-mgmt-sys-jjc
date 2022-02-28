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

    toTableRow() {
        let tr = [];
        tr.push(`<tr>`);
        tr.push(`<td>${this.user_id}</td>`);
        tr.push(`<td>${this.firstName}</td>`);
        tr.push(`<td>${this.lastName}</td>`);
        tr.push(`<td>${this.age}</td>`);
        tr.push(`</tr>`);
        return tr;
    }
}

class Appointment {
    appt_id;
    apptName;
    apptType;
    description;
    startTime;
    endTime;
    metaData;

    constructor(json) {
        this.appt_id = json.appt_id;
        this.apptName = json.apptName;
        this.apptType = json.apptType;
        this.description = json.description;
        this.startTime = json.startTime;
        this.endTime = json.endTime;
        this.metaData = json.metaData;
    }

    toString() {
        return `${this.appt_id} ${this.startTime} ${this.endTime}`;
    }

    toTableRow() {
        let tr = [];
        tr.push(`<tr>`);
        tr.push(`<td>${this.appt_id}</td>`);
        tr.push(`<td>${this.startTime}</td>`);
        tr.push(`<td>${this.endTime}</td>`);
        tr.push(`</tr>`);
        return tr;
    }
}