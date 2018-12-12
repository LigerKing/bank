create table member (
	id varchar(20) primary key,
	name varchar(20),
	age varchar(10),
	tel varchar(30)
);

desc member;

select * from member;

insert into member values ('song1234','song','30','010-2222-2222');
insert into member values ('jung1234','jung','20','010-3333-3333');
insert into member values ('park1234','park','35','010-4444-4444');
insert into member values ('lee1234','lee','29','010-5555-5555');