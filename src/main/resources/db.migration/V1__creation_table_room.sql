create sequence seq_room increment 1 start 1;
create table room (
    id integer not null primary key,
    name varchar(255) unique
);