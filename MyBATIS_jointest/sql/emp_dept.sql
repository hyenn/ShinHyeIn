--부서/사원(1:N)     사원/사원신체정보(1:1)
--부서table
drop table dept purge;
create table dept(
	deptno			number			not null,
	deptname		varchar(30)		not null,
	primary key(deptno)
);

insert into DEPT(deptno, deptname)
values((select nvl(max(deptno),0)+1 from dept),
'개발부');
insert into DEPT(deptno, deptname)
values((select nvl(max(deptno),0)+1 from dept),
'기술부');
--update dept set deptname='기술부' where deptno=2;
insert into DEPT(deptno, deptname)
values((select nvl(max(deptno),0)+1 from dept),
'관리부');

select * from dept

--사원table
drop table emp purge
create table emp(
	empno		number 			not null,
	name		varchar(30)		not null,
	phone		varchar(20)		not null,
	email		varchar(30)		null,
	zipcode		varchar(7)		null,
	address		varchar(100)	null,
	regdate		date			not null,
	deptno		number			not null,
	primary key(empno),
	foreign key(deptno) 	references dept(deptno)
);

insert into emp(empno,name,phone,email,zipcode,address,regdate,deptno)
values((select nvl(max(empno),0) + 1 from emp),
'홍길동','010-1111-2222','hong@mail.com','123-123','서울시 강남구 역삼동',
sysdate,1);
insert into emp(empno,name,phone,email,zipcode,address,regdate,deptno)
values((select nvl(max(empno),0) + 1 from emp),
'김길동','010-1111-2222','kim@mail.com','123-123','서울시 강남구 역삼동',
sysdate,1);

insert into emp(empno,name,phone,email,zipcode,address,regdate,deptno)
values((select nvl(max(empno),0) + 1 from emp),
'왕눈이','010-1111-2222','hong@mail.com','123-123','서울시 강남구 역삼동',
sysdate,2);
insert into emp(empno,name,phone,email,zipcode,address,regdate,deptno)
values((select nvl(max(empno),0) + 1 from emp),
'아로미','010-1111-2222','hong@mail.com','123-123','서울시 강남구 역삼동',
sysdate,2);

insert into emp(empno,name,phone,email,zipcode,address,regdate,deptno)
values((select nvl(max(empno),0) + 1 from emp),
'김서방','010-1111-2222','hong@mail.com','123-123','서울시 강남구 역삼동',
sysdate,3);
insert into emp(empno,name,phone,email,zipcode,address,regdate,deptno)
values((select nvl(max(empno),0) + 1 from emp),
'박서방','010-1111-2222','hong@mail.com','123-123','서울시 강남구 역삼동',
sysdate,3);

select * from emp

--신체정보table
drop table emp_body purge
create table emp_body(
	empno		number		not null,
	weight		number		default 0,
	height		number		default 0,
	blood		varchar(3)	not null,
	primary key(empno),
	foreign	key(empno)  references emp(empno)	
);

insert into emp_body(empno, weight, height, blood)
values(1,59,178,'A');
insert into emp_body(empno, weight, height, blood)
values(2,69,188,'AB');
insert into emp_body(empno, weight, height, blood)
values(3,49,168,'O');
insert into emp_body(empno, weight, height, blood)
values(4,66,172,'B');
insert into emp_body(empno, weight, height, blood)
values(5,70,188,'A');
insert into emp_body(empno, weight, height, blood)
values(6,51,168,'O');

select * from emp_body

-- 1:1 join emp:emp_body
select e.empno, e.name, e.phone, e.email, e.regdate, e.zipcode, e.address,
e.deptno, b.empno as empno2, b.weight, b.height, b.blood
from emp e, emp_body b
where e.empno = b.empno
and e.empno=1


-- 1:N join dept:emp
select e.empno, e.name, e.phone, e.email, e.regdate, e.zipcode, e.address,
e.deptno,d.deptno as deptno2, d.deptname
from emp e, dept d
where d.deptno = e.deptno
and d.deptno = 1




















