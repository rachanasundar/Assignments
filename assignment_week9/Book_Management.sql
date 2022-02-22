create database book_management_rachana;

use book_management_rachana;

create table books(
book_id int primary key,
book_name varchar(100),
author varchar(100),
book_genre varchar(100),
book_price float,
book_stock int
);
drop table books;

create table admin_log_in(
email_id varchar(100) primary key,
admin_password varchar(100)
);
drop table admin_log_in;

create table User(
email_id varchar (100) primary key,
username varchar(100),
user_password varchar(100) 
);
drop table User;

create table user_Liked_Books(
email_id varchar (100), 
book_id int,
book_name varchar(100),
foreign key (book_id) references books(book_id),
foreign key (email_id) references user(email_Id),
primary key(email_id,book_id)
);
drop table user_Liked_Books;
desc user_Liked_Books;


select * from books;
select * from Admin_Log_In;
select * from User;
select * from user_Liked_Books;




