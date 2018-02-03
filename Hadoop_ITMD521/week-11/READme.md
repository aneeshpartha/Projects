Steps to execute week 11
------------------------


Step 1 : Install sqoop , mysql and maven . I will proceed with other steps assuming that it is already installed in your system.

Step 2 : Connect to mysql and create a table called widgets. We need to create a database before proceeding with table creation.

Commands:
---------

Database creation:

CREATE DATABASE hadoopguide; 
GRANT ALL PRIVILEGES ON hadoopguide.* TO ''@'localhost'; 
use hadoopguide;

Table creation:

CREATE TABLE widgets(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
widget_name VARCHAR(64) NOT NULL,
price DECIMAL(10,2),
design_date DATE,
version INT,
design_comment VARCHAR(100));

Inserting values into the table widgets:

INSERT INTO widgets VALUES (NULL, 'sprocket', 0.25, '2010-02-10',1, 'Connects two gizmos'); 
INSERT INTO widgets VALUES (NULL, 'gizmo', 4.00, '2009-11-30', 4,NULL);
INSERT INTO widgets VALUES (NULL, 'gadget', 99.99, '1983-08-13',13, 'Our flagship product'); 
INSERT INTO widgets VALUES (NULL, 'Scribble' , 21 , '2001-05-05', 18 ,'Scribbling tool' );
INSERT INTO widgets VALUES (NULL , 'Tetrix', 34 , '1995-01-12', 'Tetrix');
INSERT INTO widgets VALUES (NULL , 'wiggly', 10 , '2010-10-31', 4 ,NULL);


Step 3 : Inserting table into HDFS:

sqoop import --connect jdbc:mysql://localhost/hadoopguide --table widgets -m 1

Step 4: Make sure that maven package command is run before running the below commands . Running maven package would create sqoop-examples.jar which will contain the programs MaxWidgetId.java and MinWidgetId.java .

Download the files uploaded in the github . It also contains sqoop-examples.jar

Once it is downloaded run the below commands

For Finding Maximum Id

hadoop jar sqoop-examples.jar MaxWidgetId -libjars $SQOOP_HOME/sqoop-1.4.6.jar


For finding the minimum Id

hadoop jar sqoop-examples.jar MinWidgetId -libjars $SQOOP_HOME/sqoop-1.4.6.jar
