use devtask_db;
drop database devtask_db;
create database devtask_db;
drop table question;
create table question
(
id int primary key  auto_increment,
title varchar(100) not null,
question_type ENUM('Best Choice', 'True or False', 'Multiple Choice','Numerical Value','Matching','Short Answer') not null,
content text,
category_id int not null,
tag varchar(2000) not null,
level_id int not null,
skill_points int not null,
score decimal not null,
duration time not null,
`status` boolean default false,
is_import boolean default false, 
constraint FK_category_id foreign key(category_id) references category(id),
constraint FK_level_id foreign key(level_id) references question_level(id)
);

drop table answer;

create table answer
(
id int primary key auto_increment,
question_id int not null,
`option` varchar(30) not null,
is_right_answer boolean default 0 not null,
right_ans_explanation varchar(100),
grading varchar(20) not null,
is_sticky Boolean default false,
constraint FK_question_id foreign key(question_id) references question(id)
);

drop table question_matching;
create table question_matching
(
id int primary key auto_increment,
question_id int not null,
answer_id int not null,
question varchar(200) not null,
constraint FK_question_id foreign key(question_id) references question(id),
constraint FK_answer_id foreign key(answer_id) references answer(id),
is_sticky boolean  default false
);

drop table category;
create table category
(
id int primary key auto_increment,
`name` varchar(20) not null
);

insert into category(`name`) values('java'),('.net'),('ajax'),('css'),('html'),('javascript'),('angular');

drop table question_level;
create table question_level
(
id int primary key auto_increment,
`name` varchar(20) not null
);

insert into question_level(`name`) values('level_100'),('level_200'),('level_300'),('level_400'),('level_500'),('level_600'),('level_700');

select * from question_table;
select * from answer_table;
select * from question_matching;
select * from category;
select * from question_level;




