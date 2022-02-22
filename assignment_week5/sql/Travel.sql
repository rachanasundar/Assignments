#to create a database
create database travel_rachana;

#to use the created database
use travel_rachana;

#to create a table named PASSENGER
create table PASSENGER
 ( Passenger_id 	int primary key auto_increment,
 Passenger_name 	varchar(20) not null, 
  Category               varchar(20) not null,
   Gender                 varchar(20) not null,
   Boarding_City      varchar(20) not null,
   Destination_City   varchar(20) not null,
  Distance                int  not null,
  Bus_Type             varchar(20) not null
  );

#to create a table named PRICE
create table PRICE
(			Bus_Type   varchar(20) not null,
             Distance    int not null,
              Price      int  primary key
          );


#to insert records into PASSENGER table 
insert into passenger(Passenger_name,Category,Gender,Boarding_City,Destination_City,Distance,Bus_Type)
 values('Sejal','AC','F','Bengaluru','Chennai',350,'Sleeper');
insert into passenger (Passenger_name,Category,Gender,Boarding_City,Destination_City,Distance,Bus_Type)
values('Anmol','Non-AC','M','Mumbai','Hyderabad',700,'Sitting');
insert into passenger (Passenger_name,Category,Gender,Boarding_City,Destination_City,Distance,Bus_Type)
values('Pallavi','AC','F','panaji','Bengaluru',600,'Sleeper');
insert into passenger (Passenger_name,Category,Gender,Boarding_City,Destination_City,Distance,Bus_Type)
values('Khusboo','AC','F','Chennai','Mumbai',1500,'Sleeper');
insert into passenger(Passenger_name,Category,Gender,Boarding_City,Destination_City,Distance,Bus_Type) 
values('Udit','Non-AC','M','Trivandrum','panaji',1000,'Sleeper');
insert into passenger (Passenger_name,Category,Gender,Boarding_City,Destination_City,Distance,Bus_Type)
values('Ankur','AC','M','Nagpur','Hyderabad',500,'Sitting');
insert into passenger (Passenger_name,Category,Gender,Boarding_City,Destination_City,Distance,Bus_Type)
values('Hemant','Non-AC','M','panaji','Mumbai',700,'Sleeper');
insert into passenger (Passenger_name,Category,Gender,Boarding_City,Destination_City,Distance,Bus_Type)
values('Manish','Non-AC','M','Hyderabad','Bengaluru',500,'Sitting');
insert into passenger (Passenger_name,Category,Gender,Boarding_City,Destination_City,Distance,Bus_Type)
values('Piyush','AC','M','Pune','Nagpur',700,'Sitting');

#to display all records in PASSENGER
select * from passenger;

#to insert records into PRICE table
insert into price(Bus_Type, Distance, Price)
 values('Sleeper',350,770);
insert into price(Bus_Type, Distance, Price)
 values('Sleeper',500,1100);
insert into price(Bus_Type, Distance, Price)
 values('Sleeper',600,1320);
insert into price(Bus_Type, Distance, Price)
 values('Sleeper',700,1540);
insert into price(Bus_Type, Distance, Price)
 values('Sleeper',1000,2200);
insert into price(Bus_Type, Distance, Price)
 values('Sleeper',1200,2640);
insert into price(Bus_Type, Distance, Price)
 values('Sitting',350,434);
insert into price(Bus_Type, Distance, Price)
 values('Sitting',500,620);
insert into price (Bus_Type, Distance, Price)
values('Sitting',600,744);
insert into price(Bus_Type, Distance, Price)
 values('Sitting',700,868);
insert into price(Bus_Type, Distance, Price)
 values('Sitting',1000,1240);
insert into price(Bus_Type, Distance, Price)
 values('Sitting',1200,1488);
insert into price(Bus_Type, Distance, Price)
 values('Sitting',1500,1860);

insert into price(Bus_Type, Distance, Price)
 values('Sleeper',1500,3000);
select * from price;

# 1. How many female and how many male passengers travelled for a minimum distance of 600 KM s?

select gender, count(*) 
from passenger 
where distance >=600
group by gender;

# 2.Find the minimum ticket price for Sleeper Bus

select min(price) as 'Minimun Price' 
from price 
where bus_type ='Sleeper';

# 3.Select passenger names whose names start with character 'S'

select Passenger_name
from passenger
where Passenger_name like 'S%';

#4. Calculate price charged for each passenger displaying Passenger name, Boarding City, Destination City, Bus_Type, Price in the output

select pass.Passenger_name, pass.Boarding_City, pass.Destination_City, pass.Bus_Type, pri.price
from passenger pass
left join price pri
on pass.distance = pri.distance and pass.bus_type = pri.bus_type
order by pass.Passenger_id
limit 5 ;


#5. What is the passenger name and his/her ticket price who travelled in Sitting bus for a distance of 1000 KMs.

select pass.Passenger_name, pass.distance, pri.price
from passenger pass 
inner join price pri
on pass.distance = pri.distance and pass.bus_type = pri.bus_type
where pass.distance  =1000;


#6. What will be the Sitting and Sleeper bus charge for Pallavi to travel from Bangalore to Panaji?

select pri.bus_type, pass.distance, pri.price
from passenger pass
inner join price pri
on pass.distance = pri.distance and  pri.distance = 600;


#7. List the distances from the "Passenger" table which are unique (non-repeated distances) in descending order.

select distinct distance
from passenger
order by distance desc
limit 5;

#8. Display the passenger name and percentage of distance travelled by that passenger from the total distance travelled by all passengers without using user variables

select Passenger_name, distance , 
concat(round(distance *100/(select sum(distance) as s from passenger )),'%') as 'Percentage of Distance Travelled'
from passenger
limit 5;


# 9. Create a view to see all passengers who travelled in AC Bus.
create view AC_bus as
select * from passenger 
where Category='AC';

select * from Ac_bus;


#10.  Create a stored procedure to find total passengers traveled using Sleeper buses
delimiter &&

   create procedure passengersTotal()
     begin
    	 select * from passenger where bus_type ='Sleeper';
     	 select count(passenger_name) as total from passenger where bus_type ='Sleeper';
     end&&
     
    call passengersTotal();
     end &&
    
