USE demo;
-- 删除emp表
DROP TABLE if EXISTS emp;
-- 删除dept表
DROP TABLE if EXISTS dept;

-- 创建dept表
CREATE TABLE dept(
deptno INT AUTO_INCREMENT,
dname VARCHAR(30) NOT NULL,
loc VARCHAR(50) NOT NULL,
CONSTRAINT pk_deptno PRIMARY KEY(deptno)
)ENGINE=INNODB DEFAULT CHARSET UTF8;

-- 创建emp表
CREATE TABLE emp(
empno INT AUTO_INCREMENT,
ename VARCHAR(30) NOT NULL,
age INT,
sal DOUBLE,
deptno INT,
CONSTRAINT pk_empno PRIMARY KEY(empno),
CONSTRAINT fk_deptno foreign KEY(deptno) REFERENCES dept(deptno) ON DELETE SET null
)ENGINE=INNODB DEFAULT CHARSET UTF8;

-- 插入部门测试数据
INSERT INTO dept(dname,loc) VALUES('开发部','南京市江宁区秣周东路9号');
INSERT INTO dept(dname,loc) VALUES('测试部','南京市江宁区秣周东路9号');
INSERT INTO dept(dname,loc) VALUES('人事部','南京市江宁区秣周东路9号');
INSERT INTO dept(dname,loc) VALUES('产品部','南京市江宁区秣周东路9号');
INSERT INTO dept(dname,loc) VALUES('消费者服务部','南京市江宁区秣周东路9号');

-- 插入雇员测试数据
INSERT INTO emp(ename,age,sal,deptno) VALUES('张三',20,8000.0,1);
INSERT INTO emp(ename,age,sal,deptno) VALUES('李四',20,4000.0,1);
INSERT INTO emp(ename,age,sal,deptno) VALUES('王二',20,7000.0,1);
INSERT INTO emp(ename,age,sal,deptno) VALUES('麻子',20,7000.0,1);
INSERT INTO emp(ename,age,sal,deptno) VALUES('zhaoyang',20,3500.0,2);
INSERT INTO emp(ename,age,sal,deptno) VALUES('john',20,9000.0,2);
INSERT INTO emp(ename,age,sal,deptno) VALUES('mike',20,2000.0,2);
INSERT INTO emp(ename,age,sal,deptno) VALUES('angry',20,10000.0,3);
INSERT INTO emp(ename,age,sal,deptno) VALUES('小红',20,4000.0,3);
INSERT INTO emp(ename,age,sal,deptno) VALUES('陈小鹏',20,2300.0,3);
INSERT INTO emp(ename,age,sal,deptno) VALUES('李晓减',20,4400.0,4);
INSERT INTO emp(ename,age,sal,deptno) VALUES('陈小斌',20,4600.0,4);
INSERT INTO emp(ename,age,sal,deptno) VALUES('王玉',20,45000.0,4);
INSERT INTO emp(ename,age,sal,deptno) VALUES('蒋思过',20,45000.0,5);
INSERT INTO emp(ename,age,sal,deptno) VALUES('潘敏',20,45000.0,5);

