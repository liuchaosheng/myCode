use demo ;

drop table if exists product_order;
drop table if exists orders;
drop table if exists product;

create table product(
proid int auto_increment,
proname varchar(100) not null,
price double not null,
count int not null,
oriprice double not null,
constraint pk_proid primary key(proid)
);

create table orders(
oid int auto_increment,
allprice double not null,
createtime datetime,
pid int,
constraint pk_oid primary key(oid),
constraint fk_pid foreign key(pid) references person(pid) on delete cascade
);

create table product_order(
poid int auto_increment,
proid int not null,
pcount int not null,
oid int not null,
constraint pk_poid primary key(poid)
);


insert into product(proname,price,count,oriprice) values('篮球',305.0,20,250);
insert into product(proname,price,count,oriprice) values('杯子',10.0,20,8.0);
insert into product(proname,price,count,oriprice) values('锅',150,25,120);
insert into product(proname,price,count,oriprice) values('小米手机',3500.0,20,2500.0);






