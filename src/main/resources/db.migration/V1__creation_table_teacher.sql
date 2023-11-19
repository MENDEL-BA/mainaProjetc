create sequence seq_teacher increment 1 start 1;
create table teacher (
    id integer not null primary key,
    name varchar(255)
);