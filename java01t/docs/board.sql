create table board (
  bno int primary key auto_increment,
  title varchar(100),
  content text
);

insert into board(title, content)
values ('aaaa', 'aaaaaaaa');

insert into board(title, content)
values ('bbbb', 'bbbbbbbb');

insert into board(title, content)
values ('ccccc', 'cccccccc');

select bno, title
from board;

update board set
  title = 'xxxx'
where bno = 1;

delete from board
where bno = 2;




