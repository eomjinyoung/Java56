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
