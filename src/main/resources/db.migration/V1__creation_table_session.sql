create sequence seq_session increment 1 start 1;
create table session (
    id integer not null primary key,
    code varchar(255) unique
);