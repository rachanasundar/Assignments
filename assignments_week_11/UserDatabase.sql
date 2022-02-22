create database week11_Users_rachana;
use week11_Users_rachana;
drop database week11_Users_rachana;

create table User(
email_id varchar (100) primary key,
username varchar(100),
user_password varchar(100) 
);
drop table User;

create table liked_Books(
email_id varchar (100) ,
book_id int,
book_name varchar(100),
author varchar(100),
book_genre varchar(100),
book_Image_Url varchar(1000),
book_price float,
book_rating float,
primary key(email_id,book_id),
foreign key (email_id) references user(email_Id)
);
 drop table liked_Books;
 
 create table read_Later_Books(
email_id varchar (100) ,
book_id int,
book_name varchar(100),
author varchar(100),
book_genre varchar(100),
book_Image_Url varchar(1000),
book_price float,
book_rating float,
primary key(email_id, book_id),
foreign key (email_id) references user(email_Id)
);
 drop table read_later_Books;
 
 select * from user;
 select * from liked_books;
 select * from read_later_Books;