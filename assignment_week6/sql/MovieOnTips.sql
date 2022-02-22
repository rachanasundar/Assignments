create database assignment6_rachana;
use assignment6_rachana;

create table genre(
genre_id int primary key,
genre1 varchar(10),
genre2 varchar(10),
genre3 varchar(10)
);

create table actors(
actor_movie_id int primary key,
actor1 varchar(100),
actor2 varchar(100),
actor3 varchar(100)

);


create table Movies_Coming_Soon( 
id int primary key,
title varchar (100),
release_year year,
genre_id int,
duration varchar(10),
releaseDate varchar(10),
actor_movie_id int,
imdbRating float ,
posterUrl varchar(1000),
foreign key (genre_id) references genre (genre_id),
foreign key (actor_movie_id) references actors (actor_movie_id)
);

create table Movies_in_theaters( 
id int primary key,
title varchar (100),
release_year year,
genre_id int,
duration varchar(10),
releaseDate varchar(10),
actor_movie_id int,
imdbRating float ,
posterUrl varchar(1000),
foreign key (genre_id) references genre (genre_id),
foreign key (actor_movie_id) references actors (actor_movie_id)
);
create table Top_Rated_Indian_Movies( 
id int primary key,
title varchar (100),
release_year year,
genre_id int,
duration varchar(10),
releaseDate varchar(10),
actor_movie_id int,
imdbRating float ,
posterUrl varchar(1000),
foreign key (genre_id) references genre (genre_id),
foreign key (actor_movie_id) references actors (actor_movie_id)
);


create table Top_Rated_Movies( 
id int primary key,
title varchar (100),
release_year year,
genre_id int,
duration varchar(10),
releaseDate varchar(10),
actor_movie_id int,
imdbRating float ,
posterUrl varchar(1000),
foreign key (genre_id) references genre (genre_id),
foreign key (actor_movie_id) references actors (actor_movie_id)
);

create table My_Favorite(
sl_no int primary key auto_increment,
id_Movies_Coming_Soon int, 
id_Movies_in_theaters int,
id_Top_Rated_Indian_Movies int, 
id_Top_Rated_Movies int, 
 foreign key (id_Movies_Coming_Soon) references Movies_Coming_Soon (id),
 foreign key (id_Movies_in_theaters) references Movies_in_theaters (id),
 foreign key (id_Top_Rated_Indian_Movies) references Top_Rated_Indian_Movies (id),
 foreign key (id_Top_Rated_Movies) references Top_Rated_Movies (id)
);



insert into genre
values (101, "Action","Comedy","Crime");
insert into genre
values (102, "Drama","Horror","Romance");
insert into genre
values (103, "Drama",null,null);
insert into genre
values (104, "Action","Crime","Drama");

insert into genre
values (201,"Action","Adventure","Sci-Fi");
insert into genre
values (202, "Animation", "Adventure","Comedy");
insert into genre
values (203,"Action","Crime","Drama");
insert into genre
values (204, "Action", "Drama", null);

insert into genre
values (301,"Drama",null,null);
insert into genre
values (302,"Action","Biography","Drama");
insert into genre
values (303,"Crime","Drama", null);
insert into genre
values (304,"Crime","Drama", "Thriller");

insert into genre
values (401, "Drama","History","War");
insert into genre
values (402,"Sci-Fi","Thriller", null);
insert into genre
values (403,"Comedy", "Drama", null);
insert into genre
values (404, "Drama","Mystery", "War");


select * from genre;


insert into actors
values (1001, "Rachel McAdams","Jesse Plemons","Jason Bateman");
insert into actors
values(1002,"Charlotte Vega","David Bradley", "Moe Dunford");
insert into actors
values (1003, "Charlotte Rampling","André Wilms","Stéphanie Van Vyve");
insert into actors
values (1004,"Daniel Radcliffe","Grace Gummer","Pablo Schreiber");

insert into actors
values (2001,"Chadwick Boseman", "Michael B. Jordan", "Lupita Nyong'o");
insert into actors
values (2002,"Tom Hiddleston",  "Eddie Redmayne", "Maisie Williams");
insert into actors
values (2003,"Anupam Kher","Sidharth Malhotra","Naseeruddin Shah");
insert into actors
values (2004,"Jackson Rathbone","Billy Zane", "Taylor James");

insert into actors
values (3001,"Rajesh Khanna","Amitabh Bachchan","Sumita Sanyal");
insert into actors
values (3002,"Aamir Khan","Sakshi Tanwar","Fatima Sana Shaikh");
insert into actors
values (3003,"Kamal Haasan","Saranya Ponvannan","Delhi Ganesh");
insert into actors
values (3004,"Kay Kay Menon","Pavan Malhotra","Aditya Srivastava");

insert into actors
values (4001,"Andrew Garfield","Sam Worthington", "Luke Bracey");
insert into actors
values (4002,"Harrison Ford","Rutger Hauer","Sean Young");
insert into actors
values (4003,"James Stewart","Jean Arthur","Claude Rains");
insert into actors
values (4004, "Lubna Azabal","Mélissa Désormeaux-Poulin","Maxim Gaudette");

Select * from  actors;

insert into Movies_Coming_Soon
values (1001,"Game Night", 2018,101,"PT100M","2018-02-28",1001,
null, "https://images-na.ssl-images-amazon.com/images/M/MV5BMjQxMDE5NDg0NV5BMl5BanBnXkFtZTgwNTA5MDE2NDM@._V1_SY500_CR0,0,337,500_AL_.jpg");

insert into Movies_Coming_Soon
values (1002,"The Lodgers",2017,102,"PT92M","2018-03-09",1002,5.8,
"https://images-na.ssl-images-amazon.com/images/M/MV5BM2FhM2E1MTktMDYwZi00ODA1LWI0YTYtN2NjZjM3ODFjYmU5XkEyXkFqcGdeQXVyMjY1ODQ3NTA@._V1_SY500_CR0,0,337,500_AL_.jpg" );

insert into Movies_Coming_Soon
values (1003,"Hannah",2017,103,"PT95M","2018-01-24",1003,6.5,"https://images-na.ssl-images-amazon.com/images/M/MV5BNWJmMWIxMjQtZTk0Mi00YTE0LTkyNzAtYzQxYjcwYjE4ZDk2XkEyXkFqcGdeQXVyMTc4MzI2NQ@@._V1_SY500_SX350_AL_.jpg");

insert into Movies_Coming_Soon
values (1004,"Beast of Burden", 2017,104,null, "2018-02",1004,6.4,"https://images-na.ssl-images-amazon.com/images/M/MV5BMjEyNTM3MDQ2NV5BMl5BanBnXkFtZTgwMDI5Nzk1NDM@._V1_SY500_CR0,0,336,500_AL_.jpg");

Select * from  Movies_Coming_Soon;

insert into Movies_in_theaters
values (2001,"Black Panther", 2018,201,"PT134M","2018-02-14",2001,7,"https://images-na.ssl-images-amazon.com/images/M/MV5BMTg1MTY2MjYzNV5BMl5BanBnXkFtZTgwMTc4NTMwNDI@._V1_SY500_CR0,0,337,500_AL_.jpg");
insert into Movies_in_theaters
values (2002,"Grottmannen Dug", 2018, 202,"PT89M","2018-03-23",2002,6.5, "https://images-na.ssl-images-amazon.com/images/M/MV5BYWMxYWVjNzAtMTY0YS00YWQyLWExMGItMjUxODkwYzQyNzMwXkEyXkFqcGdeQXVyMjMxOTE0ODA@._V1_SY500_CR0,0,328,500_AL_.jpg");
insert into Movies_in_theaters
values (2003,"Aiyaary",2018,203,"PT157M","2018-02-16",2003,null,"https://images-na.ssl-images-amazon.com/images/M/MV5BMjI1NTk0NTc1OV5BMl5BanBnXkFtZTgwNTMwMTE4NDM@._V1_SY500_CR0,0,281,500_AL_.jpg");
insert into Movies_in_theaters
values (2004,"Samson",2018,204,null,"2018-02-16",2004,5,"https://images-na.ssl-images-amazon.com/images/M/MV5BYThiMjg4ZDAtNjk5ZS00ZTUxLThmM2ItMGI0ZTE1NjRhNWNmXkEyXkFqcGdeQXVyNTQ3MjE4NTU@._V1_SY500_CR0,0,334,500_AL_.jpg");

Select * from Movies_in_theaters;



insert into Top_Rated_Indian_Movies
values (3001,"Anand",1971,301,"PT122M","1971-03-12",3001,8.9,"https://images-na.ssl-images-amazon.com/images/M/MV5BMjE0Mzk3OTk2NF5BMl5BanBnXkFtZTgwMTQ1NDk5NTE@._V1_SY250_CR0,0,187,250_AL_.jpg");
insert into Top_Rated_Indian_Movies
values (3002,"Dangal", 2016,302,"PT161M","2016-12-23",3002,8.9,"https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ4MzQzMzM2Nl5BMl5BanBnXkFtZTgwMTQ1NzU3MDI@._V1_SY500_CR0,0,356,500_AL_.jpg");

insert into Top_Rated_Indian_Movies
values (3003,"Nayakan",1982,303,"PT145M","1987-07-31",3003,8.9,"https://images-na.ssl-images-amazon.com/images/M/MV5BNTI2Zjc5ODMtNGE0NC00YjU5LTk0NjktZjU4ZDRlZDFkZWU0XkEyXkFqcGdeQXVyNjc5Mjg4Nzc@._V1_SY480_SX320_AL_.jpg");

insert into Top_Rated_Indian_Movies
values (3004,"Black Friday",2004,304,"PT143M","2007-02-09",3004,8.6,"https://images-na.ssl-images-amazon.com/images/M/MV5BMmU1NDhjYTQtYjQxYy00MjlmLWIxMjItMjllMmE2NDRlY2ZhXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_SY500_SX400_AL_.jpg");

Select * from Top_Rated_Indian_Movies;



insert into Top_Rated_Movies
values (4001,"Hacksaw Ridge",2016,401,"PT139M", "2016-11-04",4001,8.3,"https://images-na.ssl-images-amazon.com/images/M/MV5BMjQ1NjM3MTUxNV5BMl5BanBnXkFtZTgwMDc5MTY5OTE@._V1_SY500_CR0,0,323,500_AL_.jpg");
insert into Top_Rated_Movies
values (4002, "Blade Runner",1982,402,"PT117M","1982-09-10",4002,8.2,"https://images-na.ssl-images-amazon.com/images/M/MV5BZWZlYmEyYTItNGRjYy00ZmMxLWEzMWItM2Q2NjZlNTMwMjQ3XkEyXkFqcGdeQXVyNDYyMDk5MTU@._V1_SY500_CR0,0,332,500_AL_.jpg");
insert into Top_Rated_Movies
values (4003,"Mr. Smith i Washington",1939,403,"PT129M","1939-12-23",4003,8.2,"https://images-na.ssl-images-amazon.com/images/M/MV5BZTYwYjYxYzgtMDE1Ni00NzU4LWJlMTEtODQ5YmJmMGJhZjI5L2ltYWdlXkEyXkFqcGdeQXVyMDI2NDg0NQ@@._V1_SY500_CR0,0,331,500_AL_.jpg");
insert into Top_Rated_Movies
values (4004,"Nawals hemlighet",2010,404,"PT131M","2011-08-12",4004,8.2,"https://images-na.ssl-images-amazon.com/images/M/MV5BMjEyNTA3Njk4M15BMl5BanBnXkFtZTcwMzkzMzY3Mw@@._V1_SY500_CR0,0,348,500_AL_.jpg");

Select * from Top_Rated_Movies;

insert into My_Favorite(id_Movies_Coming_Soon)
value (1004);
insert into My_Favorite(id_Movies_in_theaters)
value (2002);
insert into My_Favorite(id_Top_Rated_Indian_Movies)
value (3003);
insert into My_Favorite(id_Top_Rated_Movies)
value (4002);
select * from My_Favorite


