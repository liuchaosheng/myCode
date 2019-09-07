USE demo;
-- ɾ��emp��
DROP TABLE if EXISTS emp;
-- ɾ��dept��
DROP TABLE if EXISTS dept;

-- ����dept��
CREATE TABLE dept(
deptno INT AUTO_INCREMENT,
dname VARCHAR(30) NOT NULL,
loc VARCHAR(50) NOT NULL,
CONSTRAINT pk_deptno PRIMARY KEY(deptno)
)ENGINE=INNODB DEFAULT CHARSET UTF8;

-- ����emp��
CREATE TABLE emp(
empno INT AUTO_INCREMENT,
ename VARCHAR(30) NOT NULL,
age INT,
sal DOUBLE,
deptno INT,
CONSTRAINT pk_empno PRIMARY KEY(empno),
CONSTRAINT fk_deptno foreign KEY(deptno) REFERENCES dept(deptno) ON DELETE SET null
)ENGINE=INNODB DEFAULT CHARSET UTF8;

-- ���벿�Ų�������
INSERT INTO dept(dname,loc) VALUES('������','�Ͼ��н��������ܶ�·9��');
INSERT INTO dept(dname,loc) VALUES('���Բ�','�Ͼ��н��������ܶ�·9��');
INSERT INTO dept(dname,loc) VALUES('���²�','�Ͼ��н��������ܶ�·9��');
INSERT INTO dept(dname,loc) VALUES('��Ʒ��','�Ͼ��н��������ܶ�·9��');
INSERT INTO dept(dname,loc) VALUES('�����߷���','�Ͼ��н��������ܶ�·9��');

-- �����Ա��������
INSERT INTO emp(ename,age,sal,deptno) VALUES('����',20,8000.0,1);
INSERT INTO emp(ename,age,sal,deptno) VALUES('����',20,4000.0,1);
INSERT INTO emp(ename,age,sal,deptno) VALUES('����',20,7000.0,1);
INSERT INTO emp(ename,age,sal,deptno) VALUES('����',20,7000.0,1);
INSERT INTO emp(ename,age,sal,deptno) VALUES('zhaoyang',20,3500.0,2);
INSERT INTO emp(ename,age,sal,deptno) VALUES('john',20,9000.0,2);
INSERT INTO emp(ename,age,sal,deptno) VALUES('mike',20,2000.0,2);
INSERT INTO emp(ename,age,sal,deptno) VALUES('angry',20,10000.0,3);
INSERT INTO emp(ename,age,sal,deptno) VALUES('С��',20,4000.0,3);
INSERT INTO emp(ename,age,sal,deptno) VALUES('��С��',20,2300.0,3);
INSERT INTO emp(ename,age,sal,deptno) VALUES('������',20,4400.0,4);
INSERT INTO emp(ename,age,sal,deptno) VALUES('��С��',20,4600.0,4);
INSERT INTO emp(ename,age,sal,deptno) VALUES('����',20,45000.0,4);
INSERT INTO emp(ename,age,sal,deptno) VALUES('��˼��',20,45000.0,5);
INSERT INTO emp(ename,age,sal,deptno) VALUES('����',20,45000.0,5);

