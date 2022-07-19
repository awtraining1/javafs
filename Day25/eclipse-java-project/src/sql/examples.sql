use amzn;

-- Demo Table Creation
create table FARMER (
name varchar(80) not null,
dob date,
age int,
phone int(10) not null unique,
salary float
);

-- Demo add a row (record)
insert into FARMER values ('Jagga', now(), 25, 987654321, 65000.25  );

-- Demo selecting all columns of all rows
select * from FARMER;

insert into FARMER values ('Jagga1', now(), 27, 987654320, 65000.25  );
insert into FARMER values ('Jagga2', now(), 55, 987654322, 75000.25  );
insert into FARMER values ('Jagga3', now(), 55, 987654323, 85000.25  );
insert into FARMER values ('Jagga4', now(), 75, 987654324, 45000.55  );
insert into FARMER values ('Thimma', now(), 27, 987654326, 47000.00025 );

-- Demo selecting particular columns of all rows
select name,phone from FARMER;

-- Demo selecting rows which satisfy a condition
select name,phone,salary from FARMER where salary>65000;
select name,age,salary from FARMER where salary>75000 or age>40;

-- Demo creating update triggers
delimiter //
CREATE TRIGGER update_age_negative_gt100 BEFORE UPDATE ON Farmer
FOR EACH ROW
BEGIN
	IF NEW.age < 0 THEN
		SET NEW.age = OLD.age;
	ELSEIF NEW.age > 100 THEN
		SET NEW.age = 99;
	END IF;
END;//
delimiter ;

-- Demo dropping  triggers
DROP TRIGGER update_age;

-- Demo creating insert triggers
delimiter //
CREATE TRIGGER insert_salary_lt20000 BEFORE INSERT ON Farmer
FOR EACH ROW
BEGIN
	IF NEW.salary < 20000 THEN
		SET NEW.salary = 25000;
	END IF; 
END;//
delimiter ;

-- Demo insert triggers in action
insert into FARMER values ('Shanmuga', now(), 67, 987654327, 15000.25  );

-- Demo creating table with a primary key of our choice
create table FARMER_WITH_OUR_OWN_PKEY (
farmer_id varchar(80) not null unique,
name varchar(80) not null,
dob date,
age int,
phone int(10) not null unique,
salary float,

constraint primary key (farmer_id)
);

-- Demo creating table with a primary composite key of our choice
create table FARMER_WITH_OUR_OWN_COMPOSITE_PKEY (
farmer_id varchar(80) not null unique,
name varchar(80) not null,
dob date,
age int,
phone int(10) not null unique,
salary float,

constraint primary key (name,age)
);

-- Demo testing of primary key constraint
insert into FARMER_WITH_OUR_OWN_COMPOSITE_PKEY values ('FSDDR1234','Jagga', now(), 25, 987654321, 65000.25  );
insert into FARMER_WITH_OUR_OWN_COMPOSITE_PKEY values ('FSDDR134544','Jagga', now(), 25, 987774321, 10.25  );

-- Adding a new column
 ALTER TABLE FARMER ADD COLUMN region varchar(80);
 
 /* modify column type (risky ops) */
 ALTER TABLE FARMER MODIFY COLUMN region varchar(20);
 ALTER TABLE FARMER MODIFY COLUMN salary int; -- float to int very risky
 
 -- stored procedure demo
 -- CREATE a stored procedure
delimiter //
CREATE PROCEDURE farmercount_byage (IN input_age INT, OUT farmers INT)
BEGIN
  SELECT COUNT(*) INTO farmers FROM amzn.farmer
  WHERE age = input_age;
END//
delimiter;    

-- call the prodecure
call farmercount_byage(1,@farmers);

-- fetch the result
select @farmers;
+----------+
| @farmers |
+----------+
|        3 |
+----------+

--25A Develop a SP which will return total of salaries of all farmers
delimiter //
CREATE PROCEDURE farmer_total_salary (OUT total_salary float)
BEGIN
  SELECT sum(salary) INTO total_salary FROM amzn.farmer;
END//
delimiter;   

call farmer_total_salary(@total_salary);    
select @total_salary;

-- add a new farmer and check if the total salary reflects the additional salary
-- from this farmer
insert into FARMER values ('Palak', now(), 37, 987654178, 70001.125,'KER');
call farmer_total_salary(@total_salary);    
select @total_salary;