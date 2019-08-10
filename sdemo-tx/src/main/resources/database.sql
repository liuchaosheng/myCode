use demo;
drop table if exists person;
create table person(
pid int auto_increment,
name varchar(20) not null,
age int,
sal double,
birthday datetime default '1990-10-04',
constraint pk_pid primary key(pid)
);