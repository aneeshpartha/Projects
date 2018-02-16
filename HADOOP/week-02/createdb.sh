#!/bin/sh

echo "Enter password for connecting to the database"
stty -echo
read PASSWORD
stty echo
echo "\n"
echo "show databases" | mysql -u root -p$PASSWORD
echo "\nEnter name of the new database"
read database
echo "create database $database" | mysql -u root -p$PASSWORD
echo "use $database;create table temp1 (years integer , temp integer , USAF integer , WBAN integer , obsdate integer , obstime integer,windir integer,latitudequalcode integer,longitude integer,elevation integer,dewtemp integer)" | mysql -u root -p$PASSWORD
echo "use $database;create table temp2 (years integer , temp integer , USAF integer , WBAN integer , obsdate integer , obstime integer,windir integer,latitudequalcode integer,longitude integer,elevation integer,dewtemp integer)" | mysql -u root -p$PASSWORD
echo "use $database;create table temp3 (years integer , temp integer , USAF integer , WBAN integer , obsdate integer , obstime integer,windir integer,latitudequalcode integer,longitude integer,elevation integer,dewtemp integer)" | mysql -u root -p$PASSWORD
