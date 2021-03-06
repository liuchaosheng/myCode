
-- mysql 多表创建

DROP TABLE if EXISTS person_0;
DROP TABLE if EXISTS person_1;
DROP TABLE if EXISTS person_2;
DROP TABLE if EXISTS person_3;
DROP TABLE if EXISTS person_4;


CREATE TABLE person_0(
id BIGINT,
pname VARCHAR(20),
age INT,
note TEXT,
CONSTRAINT pk_person_0 PRIMARY KEY(id)
)ENGINE INNODB DEFAULT CHARSET UTF8;

CREATE TABLE person_1(
id BIGINT,
pname VARCHAR(20),
age INT,
note TEXT,
CONSTRAINT pk_person_1 PRIMARY KEY(id)
)ENGINE INNODB DEFAULT CHARSET UTF8;

CREATE TABLE person_2(
id BIGINT,
pname VARCHAR(20),
age INT,
note TEXT,
CONSTRAINT pk_person_2 PRIMARY KEY(id)
)ENGINE INNODB DEFAULT CHARSET UTF8;

CREATE TABLE person_3(
id BIGINT,
pname VARCHAR(20),
age INT,
note TEXT,
CONSTRAINT pk_person_3 PRIMARY KEY(id)
)ENGINE INNODB DEFAULT CHARSET UTF8;

CREATE TABLE person_4(
id BIGINT,
pname VARCHAR(20),
age INT,
note TEXT,
CONSTRAINT pk_person_4 PRIMARY KEY(id)
)ENGINE INNODB DEFAULT CHARSET UTF8;


-- oracle 多表创建

DROP TABLE person_0;
DROP TABLE person_1;
DROP TABLE person_2;
DROP TABLE person_3;
DROP TABLE person_4;


CREATE TABLE person_0(
id NUMBER(20),
pname VARCHAR2(20),
age NUMBER(3),
note CLOB,
CONSTRAINT pk_person_0 PRIMARY KEY(id)
);

CREATE TABLE person_1(
id NUMBER(20),
pname VARCHAR2(20),
age NUMBER(3),
note CLOB,
CONSTRAINT pk_person_1 PRIMARY KEY(id)
);

CREATE TABLE person_2(
id NUMBER(20),
pname VARCHAR2(20),
age NUMBER(3),
note CLOB,
CONSTRAINT pk_person_2 PRIMARY KEY(id)
);

CREATE TABLE person_3(
id NUMBER(20),
pname VARCHAR2(20),
age NUMBER(3),
note CLOB,
CONSTRAINT pk_person_3 PRIMARY KEY(id)
);

CREATE TABLE person_4(
id NUMBER(20),
pname VARCHAR2(20),
age NUMBER(3),
note CLOB,
CONSTRAINT pk_person_4 PRIMARY KEY(id)
);

INSERT INTO person_4(id,pname,age,note) values(1567872180142,'aaaa',30,'牛逼');