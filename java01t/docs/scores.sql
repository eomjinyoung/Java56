create table SCORES(
    SNO INT NOT NULL auto_increment,
  NAME VARCHAR(30) NOT NULL,
  KOR INT NOT NULL,
  ENG INT NOT NULL,
  MATH INT NOT NULL,
  primary key(SNO)
);

select * from scores;

select * from scores order by sno desc;

delete from scores
where sno in (7,9,11,13);

select sno, name, kor, eng, math  
from scores order by sno desc limit 1;

select *
from scores
where sno < 10
order by sno desc limit 1;

/* max(컬럼) => 가장 큰 값 찾기 */
select max(sno) from scores where sno < 10;

/* 서브 쿼리 => select 절, from 절, where 절에 사용할 수 있다.*/
select *
from scores
where sno = ( select max(sno) from scores where sno < 10 );

select *
from scores
where sno = ( select min(sno) from scores where sno > 14 );

/* from 절에 서브 쿼리 적용 */
select *
from ( select sno, name from scores where sno < 10 order by sno desc) as t1
limit 1;