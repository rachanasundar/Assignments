create database books_app_rachana;
use books_app_rachana;

create table books(
bookid int primary key,
bookname varchar(100),
author varchar(100),
bookgenre varchar(100),
bookImageUrl varchar(1000),
bookrating float,
bookPublisher varchar(100)
);

drop table books;

create table LogIn(
phonenumber varchar(10) primary key,
emailId varchar(100),
name varchar(100),
password varchar(100)
);

drop table login;

create table likedBooks(
phonenumber varchar(10) ,
bookid int ,
bookname varchar(100),
author varchar(100),
bookgenre varchar(100),
bookImageUrl varchar(1000),
bookrating float,
bookPublisher varchar(100),
foreign key (phonenumber) references  LogIn(phonenumber),
foreign key (bookid) references books(bookid)
);
 
drop table likedBooks;
 
 create table readLater(
phonenumber varchar(10) ,
bookid int ,
bookname varchar(100),
author varchar(100),
bookgenre varchar(100),
bookImageUrl varchar(1000),
bookrating float,
bookPublisher varchar(100),
foreign key (phonenumber) references  LogIn(phonenumber),
foreign key (bookid) references books(bookid)
);

drop table readlater;

insert into books
value(101,"Wings of Fire","Arun Tiwari","Autobiography","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSIbxbKwRE7v4599QdDOor8zzJmtnBV4Vlls7soOOUZSLweNXqnyQ6PNDo071kvo87WlNw&usqp=CAU",
4.8,"Universities Press" );
insert into books
value(102, "The Alchemist", " Paulo Coelho", "Adventure fiction", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKOZsc98buRbdG1ufcg3OLiqmey1knQTpF7A&usqp=CAU",
4.7, "HarperCollins");

insert into books
value (103, "Who Will Cry When you Die?", "Robin Sharma", "Personality Development", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBDkAGpAs7Mpeqae1oP-uYyDM2_0U_tBnk-Q&usqp=CAU", 4.6,"JAICO BOOKS" );

insert into books
value (104,"The Power Of Your Subconscious Mind", "Joseph Murphy","Self-Help","https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1386924010l/68984.jpg", 4.7,"Simon & Schuster");

insert into books
value(105,"What-If"," Randall Munroe", "Humor", "https://d3525k1ryd2155.cloudfront.net/h/847/615/1384615847.0.x.jpg",
4.5,"John Murray Press");

insert into books
value(106,"The Power of Habit", " Charles Duhigg", "Self-help","https://upload.wikimedia.org/wikipedia/en/7/7f/The_Power_of_Habit.jpg",
4.7," Random House Trade Paperbacks");

insert into books
value(107, "Brain Rules", "John Medina","Self-help","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTcHV-pqSGpnQsXGr2cWBwBfhLNTyWyObEOy12ybAkFCwyUCCYR",
4, "Pear Press");

insert into books
value(108, "Long Walk to Freedom", "Nelson Mandela", "Autobiography", "https://upload.wikimedia.org/wikipedia/en/7/74/Long_Walk_to_Freedom.jpg",
4.3, " Brown Book Group");
insert into books
value(109, "The Silent Patient", " Alex Michaelides","Psychological thriller","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRw8eeYcUICY3fyGrdpCI_AcCPNuVLrU9hgGA&usqp=CAU",
4.7,"Celadon Books");
insert into books
values(110, "The Secret", ": Rhonda Byrne", "Self-help","https://upload.wikimedia.org/wikipedia/en/0/02/TheSecretLogo.jpg",
4.6,"Beyond Words Publishing");


select * from books;
select * from login;
select * from likedBooks;
select * from readlater;
