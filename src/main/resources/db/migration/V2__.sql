CREATE TABLE room
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)          NULL,
    CONSTRAINT pk_room PRIMARY KEY (id)
);

CREATE TABLE rooms_sessions
(
    room_id    BIGINT NOT NULL,
    session_id BIGINT NOT NULL
);

CREATE TABLE session
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    code VARCHAR(255)          NULL,
    CONSTRAINT pk_session PRIMARY KEY (id)
);

CREATE TABLE teacher
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)          NULL,
    CONSTRAINT pk_teacher PRIMARY KEY (id)
);

CREATE TABLE teachers_rooms
(
    room_id    BIGINT NOT NULL,
    teacher_id BIGINT NOT NULL
);

ALTER TABLE room
    ADD CONSTRAINT uc_room_name UNIQUE (name);

ALTER TABLE session
    ADD CONSTRAINT uc_session_code UNIQUE (code);

ALTER TABLE rooms_sessions
    ADD CONSTRAINT fk_rooses_on_room FOREIGN KEY (room_id) REFERENCES room (id);

ALTER TABLE rooms_sessions
    ADD CONSTRAINT fk_rooses_on_session FOREIGN KEY (session_id) REFERENCES session (id);

ALTER TABLE teachers_rooms
    ADD CONSTRAINT fk_tearoo_on_room FOREIGN KEY (room_id) REFERENCES room (id);

ALTER TABLE teachers_rooms
    ADD CONSTRAINT fk_tearoo_on_teacher FOREIGN KEY (teacher_id) REFERENCES teacher (id);