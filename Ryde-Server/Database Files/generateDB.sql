DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Group;
DROP TABLE IF EXISTS Timeslot;
DROP TABLE IF EXISTS GroupUser;
DROP TABLE IF EXISTS GroupTimeslot;
DROP TABLE IF EXISTS TimeslotUser;

CREATE TABLE User
(
    id INT NOT NULL AUTO_INCREMENT,
    driver_status boolean,
    last_name VARCHAR (64),
    first_name VARCHAR (64),
    fb_tok VARCHAR(256),
    phone_number VARCHAR (15),
    car_make VARCHAR (32),
    car_model VARCHAR (32),
    car_color VARCHAR (32),
    PRIMARY KEY (id)
);

CREATE TABLE Group
(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR (64) NOT NULL,
    description VARCHAR (64) NOT NULL,    
    PRIMARY KEY (id)
);

CREATE TABLE Timeslot 
(
    id INT NOT NULL AUTO_INCREMENT,
    passcode VARCHAR (64),
    start_time DATETIME DEFAULT NULL,
    end_time DATETIME DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE GroupUser 
(
    user_id INT NOT NULL,
    group_id INT NOT NULL,
    admin boolean,
    PRIMARY KEY (user_id, group_id),
    FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE,
    FOREIGN KEY (group_id) REFERENCES Group(id) ON DELETE CASCADE
);

CREATE TABLE TimeslotUser
(
    user_id INT NOT NULL,
    ts_id INT NOT NULL,
    driver boolean,
    PRIMARY KEY (user_id, ts_id),
    FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE,
    FOREIGN KEY (ts_id) REFERENCES TimeSlot(id) ON DELETE CASCADE
);

CREATE TABLE GroupTimeslot
(
    group_id INT NOT NULL,
    ts_id INT NOT NULL,
    PRIMARY KEY (group_id, ts_id),
    FOREIGN KEY (group_id) REFERENCES Group(id) ON DELETE CASCADE,
    FOREIGN KEY (ts_id) REFERENCES TimeSlot(id) ON DELETE CASCADE
);