
create table users(email varchar, password varchar, role varchar);
-- vanrossum
insert into users(email, password, role)
values('guido@mail.com','$2a$10$1X8qnW89UrB9zrjRvSLf4.H4u/ZkAXvyWoJMdXGwTIlGA6t3vcquq','CLIENT');

-- gosling
insert into users(email, password, role)
values('james@mail.com', '$2a$10$8bhmeA37YHbBaWpvFvSuC.3rtuZd.GV4fM63qSSoQ9SPSb4kelDze', 'ADMIN');