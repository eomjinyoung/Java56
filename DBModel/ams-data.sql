/* 1. 회원 기본 정보 입력 */
insert into  MEMBERS (NAME, EMAIL, TEL, PWD)
values ('aaaa', 'aaaa@test.com', '1111-1111', '1111'); 

insert into  MEMBERS (NAME, EMAIL, TEL, PWD)
values ('홍길동', 's1@test.com', '1111-1111', '1111'); 

insert into  MEMBERS (NAME, EMAIL, TEL, PWD)
values ('임꺽정', 's2@test.com', '1111-2222', '1111'); 

insert into  MEMBERS (NAME, EMAIL, TEL, PWD)
values ('장보고', 's3@test.com', '1111-3333', '1111'); 

insert into  MEMBERS (NAME, EMAIL, TEL, PWD)
values ('이순신', 's4@test.com', '1111-4444', '1111'); 

insert into  MEMBERS (NAME, EMAIL, TEL, PWD)
values ('유관순', 's5@test.com', '1111-5555', '1111'); 

/* 2. 강사 정보 입력 */
-- MNO는 외부키이다. MEMBERS에 존재하는 PK 값이 와야한다. 
insert into TEACHERS (MNO, POSITION)
values (2, '수석강사');

insert into TEACHERS (MNO, POSITION)
values (3, '책임강사');

/* 3. 학생 정보 입력 */
insert into STUDENTS (MNO, SCHOOL, GRADE, MAJOR)
values (4, '대한대학교', '3학년', '철학과');

insert into STUDENTS (MNO, SCHOOL, GRADE, MAJOR)
values (5, '민국대학교', '졸업', '국어국문학과');

insert into STUDENTS (MNO, SCHOOL, GRADE, MAJOR)
values (6, '한국대학교', '4학년', '게임학과');

/* 4. SELECT */
select * 
from MEMBERS;

select *
from TEACHERS;

select *
from STUDENTS;

/* 5. DELETE */
-- delete from 테이블명 where 조건절 
delete from MEMBERS
where MNO = 1;

-- 자식테이블에 연결된 데이터가 있다면 삭제 불가!
-- 만약 부모 테이블의 레코드를 삭제하고 싶다면, 
-- 먼저 자식테이블에서 관련 레코드를 찾아 삭제해야 한다.
delete from TEACHERS 
where MNO = 2;

delete from MEMBERS
where MNO = 2;

/* 6. UPDATE */
/*
update 테이블명 set 컬럼명=값, 컬럼명=값, ... where 조건절;
*/
update STUDENTS set 
  GRADE = '졸업',
  COMPANY = '알짜통신',
  COMP_CODE = '123-12345-12',
  WORKING = 'Y'
where MNO = 4;

/* 7. 컬럼 추가 */
alter table MEMBERS 
  add column VALID char(1) null default 'Y' COMMENT '유효여부';
  
/* 8. 회원 기본 정보 추가 */
insert into  MEMBERS (NAME, EMAIL, TEL, PWD)
values ('안중근', 's6@test.com', '1111-6666', '1111'); 

/* 9. 과목 등록 */
insert into SUBJECTS (TITLE, DESCR, CAPACITY)
values ('자바기초', '자바 기초 배우기', 30);

insert into SUBJECTS (TITLE, DESCR, CAPACITY)
values ('자바응용', '자바 응용', 25);

insert into SUBJECTS (TITLE, DESCR, CAPACITY)
values ('자바 웹 프로그래밍', '자바 웹 프로그래밍 배우기', 35);

insert into SUBJECTS (TITLE, DESCR, CAPACITY)
values ('C 기초', 'C 프로그래밍 기초', 20);

insert into SUBJECTS (TITLE, DESCR, CAPACITY)
values ('윈도우 프로그래밍', '위도우 프로그래밍 배우기', 30);

/* 10. 과목에 강사 배정 */
/* 조건절 or 연산자 */
update SUBJECTS set
  mno = 3
where subno = 1 or subno = 2;

/* 조건절 in 연산자 */
update SUBJECTS set
  mno = 9
where subno in (4, 5);

/* 11. 수강 신청 */
insert into SUB_REQS (SUBNO, MNO, REG_DATE)
values (1, 4, now());

insert into SUB_REQS (SUBNO, MNO, REG_DATE)
values (1, 5, now());

insert into SUB_REQS (SUBNO, MNO, REG_DATE)
values (2, 5, now());

insert into SUB_REQS (SUBNO, MNO, REG_DATE)
values (2, 6, now());

/* 존재하지 않는 학생은 입력 불가*/
insert into SUB_REQS (SUBNO, MNO, REG_DATE)
values (2, 7, now());


/* 12. select */
/* SELECT: 행 선택("selection") */
select *
from MEMBERS
where MNO > 6;

/* 열선택 ("projection") */
select name, email
from MEMBERS;

/* 행과 열 선택 */
select name, email
from MEMBERS
where mno > 4;

/* all 키워드 */
select subno, mno, reg_date
from sub_reqs;

/* all => 결과 값의 중복을 허용한다. 기본이 all */
select all mno
from sub_reqs;

select MNO
from sub_reqs;

/* distinct => 결과 값의 중복을 제거한다. */
select distinct mno
from sub_reqs;

/* order by => 결과 값 정렬*/
/* 기본은 오름차순(ASCending) */
select mno, name, email
from members
order by name;

select mno, name, email
from members
order by name asc;

/* 내림차순 정렬(DESCending)*/
select mno, name, email
from members
order by name desc;

/* alias => 출력 결과 컬럼의 이름 바꾸기 */
select mno, name, email, tel, pwd 
from members;

select mno memberNo, name, email, tel Phone, pwd Password 
from members;

select mno as memberNo, name, email, tel as Phone, pwd as Password 
from members;

/* 별명에 공백을 포함하고 싶으면 싱글 따옴표로 표시하라*/
select mno 'Member No', name, email, tel Phone, pwd Password 
from members;

/* 복합 컬럼 결과 값 */
select concat(name, '(', email , ')')  as name2
from members;

/* + 연산자 사용*/
select subno, title, capacity, capacity + (capacity * 0.1) as max_capacity
from subjects;

/* in 연산자 */
select *
from members
where mno in (3, 4, 5);

/* between a and b 연산자 */
select *
from members 
where mno between 3 and 5;

/* 비교 연산자 */
select *
from members
where mno >= 3 and mno <= 5;

/* like 연산자 */
select *
from members
where name like '임%';

select *
from members
where name like '%순';

/* 다음 질의문은 속도가 느리다*/
select *
from subjects
where descr like '%기초%';

/* 글자 하나를 와일드로 지정 */
select *
from members
where name like '_중_';

/* is null 연산자 */
select *
from students
where company is null;

select *
from students
where company is not null;

/* 빈문자열도 값이다. null 이 아니다.*/
select *
from students
where company = '';




