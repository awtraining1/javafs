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