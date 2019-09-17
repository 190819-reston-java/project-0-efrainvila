/*	JavaSpring Bank Database Operations For Project 0
 *	=================================================
 * 								@author Efrain Vila
 * 
 *	Database Name	: JavaSpring
 *	Schema 			: Public (Orginally QuickTeller but removed do to refactoring of Java code)
 * 	Tables			: Customer, Account
 *  Keys			: PK Customerid, PK FK Accountid
 * 
 */

-- JavaSpring Bank : Database for Banking App
CREATE DATABASE javaspring;

-- JavaSpring Tables
---------------------
CREATE TABLE customer ( 
	customerid SERIAL PRIMARY KEY, 
	lastname VARCHAR(50) NOT NULL,
	firstname VARCHAR(50) NOT NULL,
	username VARCHAR(50) NOT NULL,
	pwd VARCHAR(50) NOT NULL
);

--DROP TABLE customer CASCADE;

CREATE TABLE account(
	accountid SERIAL PRIMARY KEY, 
	accountnumber varchar(9) UNIQUE NOT NULL,
	accounttype varchar (10) CHECK (accounttype IN ('New','Basic', 'Premium', 'DEVELOPER')),
	accountbalance NUMERIC (8,2) NOT NULL DEFAULT(0.00),
	FOREIGN KEY (accountid) REFERENCES customer(customerid) 
	);

DROP TABLE account;

--Inserting Values into Tables
------------------------------
INSERT INTO customer VALUES 
	(DEFAULT, 'Zeno', 'April', 'AprilZ', '1470'),
	(DEFAULT, 'Young', 'Bert', 'BertY', '2580'),
	(DEFAULT, 'Xaiver', 'Charlie', 'CXaiver', '3690'),
	(DEFAULT, 'Wilson', 'Denise', 'DWilson', '1357'),
	(DEFAULT, 'Victoria', 'Elena', 'ElenaVictoria', '2468'),
	(DEFAULT, 'Vila', 'Efrain', 'MegaMan', '200X');
	
INSERT INTO account VALUES 
	(DEFAULT, 335597822 , 'Basic', 450.00),
	(DEFAULT, 787049715 , 'Basic', 125.00),
	(DEFAULT, 824468329 , 'Premium', 1500.00),
	(DEFAULT, 365804392 , 'Premium', 250000.00),
	(DEFAULT, 617505906 , 'New', DEFAULT),
	(DEFAULT, 133701337 , 'DEVELOPER', 999999.00);

-- Queries of Tables
--------------------
SELECT * FROM customer;

SELECT * FROM account;

SELECT * FROM customer FULL JOIN account ON customer.customerid = account.accountid;  -- FULL JOIN worked (INNER JOIN failed, could not see first column of each table)

-- Select statements used for Java code
-----------------------------------------------
-----------------------------------------------


-- Pulling from database for comparison 
---------------------------------------
SELECT * FROM customer WHERE username = 'AprilZ'; -- remove 'AprilZ' and replace with ?
SELECT pwd FROM customer WHERE pwd = '1470'; -- remove '1470' and replace with ?

SELECT lastname, firstname FROM customer WHERE username = 'AprilZ'; -- remove 'AprilZ' and replace with ?

SELECT * FROM customer INNER JOIN account ON customerid = accountid WHERE username = 'AprilZ'; -- remove 'AprilZ' and replace with ?
SELECT accountnumber FROM customer INNER JOIN account ON customerid = accountid WHERE username = 'AprilZ'; -- remove 'AprilZ' and replace with ?

-- View current record
-----------------------
SELECT * FROM customer FULL JOIN account ON customerid = accountid WHERE username = 'AprilZ'; -- remove 'AprilZ' and replace with ?

-- Updating balance
-------------------
UPDATE account SET accountbalance = 5.00 WHERE accountnumber = '335597822'; -- remove '335597822' from accountnumber and also remove '5.00' from acount balance and replace both with ?
