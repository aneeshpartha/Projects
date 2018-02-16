INSERT INTO atbladmin VALUES (401,"root","xyz@gmail.com",983728,"texas")

INSERT INTO atblcustomer VALUES (123,"Aneesh","Partha",7676576,"aneesh@gmail.com","3001 South king drive")

INSERT INTO a_login (username,PASSWORD,user_type,admin_id) VALUES ("root","root","admin",401)
INSERT INTO a_login (username,PASSWORD,user_type,cust_id) VALUES ("aneesh","aneesh","customer",123)

SELECT * FROM a_login

CREATE TABLE a_login(
username VARCHAR(20),
PASSWORD VARCHAR(20),
user_type VARCHAR(20),
cust_id INT REFERENCES atblcustomer(Cust_id),
admin_id INT REFERENCES atbladmin(admin_id),
PRIMARY KEY(username,PASSWORD)
)

CREATE TABLE atblcarddetail(
cust_name VARCHAR(20)PRIMARY KEY,
cvv INT,
cardnumber INT(20)
)

SELECT * FROM atblcarddetail;

INSERT INTO atblcarddetail VALUES ("aneesh",889,1234567898765432)


CREATE TABLE atblshow (
showid INT PRIMARY KEY,
showtime VARCHAR(20),
showtype VARCHAR(20)
)	

INSERT INTO atblshow VALUES(302,"6:00PM","Evening show")

SELECT * FROM atblshow;

CREATE TABLE atblscreen (
Screen_id INT PRIMARY KEY,
Screen_name VARCHAR(20),
Theatre_id INT 
)

CREATE TABLE tbltheatre (
Theatre_id INT PRIMARY KEY,
Theatre_name VARCHAR(20),
Theatre_city VARCHAR(20),
Theatre_state VARCHAR(20),
Theatre_Zip INT
)

INSERT INTO tbltheatre (Theatre_id,
SELECT * FROM atbltheatre;

INSERT INTO tbltheatre VALUES (100,"Chicago Theatre","chicago","illinois",60616);
INSERT INTO tbltheatre VALUES (101,"Harris","chicago","illinois",60616);
INSERT INTO tbltheatre VALUES (102,"Sunshine","New york","New york",60684);
INSERT INTO tbltheatre VALUES (103,"AMCS","New York","New York",60684);
INSERT INTO tbltheatre VALUES (104,"Regal","las angeles","California",60938);
INSERT INTO tbltheatre VALUES (105,"landmark","las angeles","California",60938);
INSERT INTO tbltheatre VALUES (106,"AMC","san fransisco","California",87654);
INSERT INTO tbltheatre VALUES (107,"Castro","san fransisco","California",87654);
INSERT INTO tbltheatre VALUES (108,"indiana","washington","washington",60632);
INSERT INTO tbltheatre VALUES (109,"edge","washington","washington",60632);

SELECT * FROM atbltheatre


CREATE TABLE tblmovie(
Movie_id INT PRIMARY KEY,
Movie_name VARCHAR(20),
movie_pic VARCHAR(100),
movie_desc VARCHAR(100)
)

INSERT INTO tblmovie VALUES (987,"Ranjana","https://i.ytimg.com/vi/ER9vmhxFucg/hqdefault.jpg","Ranjana")

SELECT * FROM tblmovie;

CREATE TABLE atblscreen (
Screen_id INT PRIMARY KEY,
Screen_name VARCHAR(20),
Theatre_id INT REFERENCES tbltheatre(Theatre_id)
)

SELECT * FROM atblscreen




INSERT INTO atblscreen VALUES(200,"Stromberg",100);
INSERT INTO atblscreen VALUES(201,"Grant",100);
INSERT INTO atblscreen VALUES(202,"Dwan",100);
INSERT INTO atblscreen VALUES(203,"Newt",100);
INSERT INTO atblscreen VALUES(204,"Wilma ",101);
INSERT INTO atblscreen VALUES(205,"Blaine",101);
INSERT INTO atblscreen VALUES(206,"McDonnagh",101);
INSERT INTO atblscreen VALUES(207,"Stacker",101);
INSERT INTO atblscreen VALUES(208,"Matrix",102);
INSERT INTO atblscreen VALUES(209,"Maxwell",102);
INSERT INTO atblscreen VALUES(210,"Trickle",102);
INSERT INTO atblscreen VALUES(211,"Vandamm",102);
INSERT INTO atblscreen VALUES(212,"Driver",103);
INSERT INTO atblscreen VALUES(213,"Christmas",103);
INSERT INTO atblscreen VALUES(214,"Jones",103);
INSERT INTO atblscreen VALUES(215,"Maggot",103);
INSERT INTO atblscreen VALUES(216,"Sloneker",104);
INSERT INTO atblscreen VALUES(217,"Dembo",104);
INSERT INTO atblscreen VALUES(218,"Majestyk",104);
INSERT INTO atblscreen VALUES(219,"Borans",104);
INSERT INTO atblscreen VALUES(220,"Kint",105);
INSERT INTO atblscreen VALUES(221,"Lancaster",105);
INSERT INTO atblscreen VALUES(222,"Meridian",105);
INSERT INTO atblscreen VALUES(223,"Snootles",105);
INSERT INTO atblscreen VALUES(224,"Hand",106);
INSERT INTO atblscreen VALUES(225,"Vincent",106);
INSERT INTO atblscreen VALUES(226,"Driftwood",106);
INSERT INTO atblscreen VALUES(227,"Shtupp",106);
INSERT INTO atblscreen VALUES(228,"Mister",107);
INSERT INTO atblscreen VALUES(229,"Brown",107);
INSERT INTO atblscreen VALUES(230,"Baxter",107);
INSERT INTO atblscreen VALUES(231,"Fink",107);
INSERT INTO atblscreen VALUES(232,"Sugar",108);
INSERT INTO atblscreen VALUES(233,"Broomhilda",108);
INSERT INTO atblscreen VALUES(234,"Santanico",108);
INSERT INTO atblscreen VALUES(235,"Donnie",108);
INSERT INTO atblscreen VALUES(236,"Indiana",109);
INSERT INTO atblscreen VALUES(237,"Mussburger",109);
INSERT INTO atblscreen VALUES(238,"Harrington",109);
INSERT INTO atblscreen VALUES(239,"Plissken",109);



CREATE TABLE atblmovierun (
movierun_id INT PRIMARY KEY,
Movie_id INT REFERENCES tblmovie(Movie_id) ,
Theatre_id INT REFERENCES tbltheatre(Theatre_id),
Screen_id INT REFERENCES atblscreen(Screen_id) ,
showid INT REFERENCES atblshow(showid)
)







INSERT INTO atblmovierun VALUES(1,356,100,200,300);
INSERT INTO atblmovierun VALUES(2,356,100,200,301);
INSERT INTO atblmovierun VALUES(3,356,100,200,302);
INSERT INTO atblmovierun VALUES(4,975,100,201,300);
INSERT INTO atblmovierun VALUES(5,975,100,201,301);
INSERT INTO atblmovierun VALUES(6,975,100,201,302);
INSERT INTO atblmovierun VALUES(7,887,100,202,300);
INSERT INTO atblmovierun VALUES(8,887,100,202,301);
INSERT INTO atblmovierun VALUES(9,887,100,202,302);
INSERT INTO atblmovierun VALUES(10,923,100,203,300);
INSERT INTO atblmovierun VALUES(11,923,100,203,301);
insert into atblmovierun values(12,923,100,203,302);
insert into atblmovierun values(13,356,101,204,300);
insert into atblmovierun values(14,356,101,204,301);
insert into atblmovierun values(15,356,101,204,302);
insert into atblmovierun values(16,975,101,205,300);
insert into atblmovierun values(17,975,101,205,301);
insert into atblmovierun values(18,975,101,205,302);
insert into atblmovierun values(19,887,101,206,300);
insert into atblmovierun values(20,887,101,206,301);
insert into atblmovierun values(21,887,101,206,302);
insert into atblmovierun values(22,923,101,207,300);
insert into atblmovierun values(23,923,101,207,301);
insert into atblmovierun values(24,923,101,207,302);
insert into atblmovierun values(25,356,102,208,300);
insert into atblmovierun values(26,356,102,208,301);
insert into atblmovierun values(27,356,102,208,302);
insert into atblmovierun values(28,975,102,209,300);
insert into atblmovierun values(29,975,102,209,301);
insert into atblmovierun values(30,975,102,209,302);
insert into atblmovierun values(31,887,102,210,300);
insert into atblmovierun values(32,887,102,210,301);
insert into atblmovierun values(33,887,102,210,302);
insert into atblmovierun values(34,923,102,211,300);
insert into atblmovierun values(35,923,102,211,301);
insert into atblmovierun values(36,923,102,211,302);
insert into atblmovierun values(37,356,103,212,300);
insert into atblmovierun values(38,356,103,212,301);
insert into atblmovierun values(39,356,103,212,302);
insert into atblmovierun values(40,975,103,213,300);
insert into atblmovierun values(41,975,103,213,301);
insert into atblmovierun values(42,975,103,213,302);
insert into atblmovierun values(43,887,103,214,300);
insert into atblmovierun values(44,887,103,214,301);
insert into atblmovierun values(45,887,103,214,302);
insert into atblmovierun values(46,923,103,215,300);
insert into atblmovierun values(47,923,103,215,301);
insert into atblmovierun values(48,923,103,215,302);
insert into atblmovierun values(49,356,104,216,300);
insert into atblmovierun values(50,356,104,216,301);
insert into atblmovierun values(51,356,104,216,302);
insert into atblmovierun values(52,975,104,217,300);
insert into atblmovierun values(53,975,104,217,301);
insert into atblmovierun values(54,975,104,217,302);
insert into atblmovierun values(55,887,104,218,300);
insert into atblmovierun values(56,887,104,218,301);
insert into atblmovierun values(57,887,104,218,302);
insert into atblmovierun values(58,923,104,219,300);
insert into atblmovierun values(59,923,104,219,301);
insert into atblmovierun values(60,923,104,219,302);
insert into atblmovierun values(61,356,105,220,300);
insert into atblmovierun values(62,356,105,220,301);
insert into atblmovierun values(63,356,105,220,302);
insert into atblmovierun values(64,975,105,221,300);
insert into atblmovierun values(65,975,105,221,301);
insert into atblmovierun values(66,975,105,221,302);
insert into atblmovierun values(67,887,105,222,300);
insert into atblmovierun values(68,887,105,222,301);
insert into atblmovierun values(69,887,105,222,302);
insert into atblmovierun values(70,923,105,223,300);
insert into atblmovierun values(71,923,105,223,301);
insert into atblmovierun values(72,923,105,223,302);
insert into atblmovierun values(73,356,106,224,300);
insert into atblmovierun values(74,356,106,224,301);
insert into atblmovierun values(75,356,106,224,302);
insert into atblmovierun values(76,975,106,225,300);
insert into atblmovierun values(77,975,106,225,301);
insert into atblmovierun values(78,975,106,225,302);
insert into atblmovierun values(79,887,106,226,300);
insert into atblmovierun values(80,887,106,226,301);
insert into atblmovierun values(81,887,106,226,302);
insert into atblmovierun values(82,923,106,227,300);
insert into atblmovierun values(83,923,106,227,301);
insert into atblmovierun values(84,923,106,227,302);
insert into atblmovierun values(85,356,107,228,300);
insert into atblmovierun values(86,356,107,228,301);
insert into atblmovierun values(87,356,107,228,302);
insert into atblmovierun values(88,975,107,229,300);
insert into atblmovierun values(89,975,107,229,301);
insert into atblmovierun values(90,975,107,229,302);
insert into atblmovierun values(91,887,107,230,300);
insert into atblmovierun values(92,887,107,230,301);
insert into atblmovierun values(93,887,107,230,302);
insert into atblmovierun values(94,923,107,231,300);
insert into atblmovierun values(95,923,107,231,301);
insert into atblmovierun values(96,923,107,231,302);
insert into atblmovierun values(97,356,108,232,300);
insert into atblmovierun values(98,356,108,232,301);
insert into atblmovierun values(99,356,108,232,302);
insert into atblmovierun values(100,975,108,233,300);
insert into atblmovierun values(101,975,108,233,301);
insert into atblmovierun values(102,975,108,233,302);
insert into atblmovierun values(103,887,108,234,300);
insert into atblmovierun values(104,887,108,234,301);
insert into atblmovierun values(105,887,108,234,302);
insert into atblmovierun values(106,923,108,235,300);
insert into atblmovierun values(107,923,108,235,301);
insert into atblmovierun values(108,923,108,235,302);
insert into atblmovierun values(109,356,109,236,300);
insert into atblmovierun values(110,356,109,236,301);
insert into atblmovierun values(111,356,109,236,302);
insert into atblmovierun values(112,975,109,237,300);
insert into atblmovierun values(113,975,109,237,301);
insert into atblmovierun values(114,975,109,237,302);
insert into atblmovierun values(115,887,109,238,300);
insert into atblmovierun values(116,887,109,238,301);
insert into atblmovierun values(117,887,109,238,302);
insert into atblmovierun values(118,923,109,239,300);
insert into atblmovierun values(119,923,109,239,301);
insert into atblmovierun values(120,923,109,239,302);


select * from atblcarddetail;

select * from atblcustomer;

select * from a_login;

select * from tblmovie;

update tblmovie set movie_pic="https://i.ytimg.com/vi/EmcRejckjjs/maxresdefault.jpg" where movie_id=356

select * from atblscreen;

select * from atblcustomer;

select * from tbltheatre;
select * from atblshow;
select Screen_name from atblscreen where Screen_id = (select Screen_id from atblmovierun where Movie_id = ( select Movie_id from tblmovie where Movie_name = "Arrival" ) and Theatre_id = ( select Theatre_id from tbltheatre where Theatre_name="AMCS") and Showid = (select Showid from atblshow where showtime="11:00AM"));


update atblshow set showtime="2:00PM" where showid=301