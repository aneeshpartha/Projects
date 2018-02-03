##Steps to be followed for running the script and code:

##1.createdb Script :

Place createdb.sh under /vagrant in virtual machine and execute the script.

The script will take password as input . Enter "safestsystemever" as the password since it is the root password for logging in into the database.
Once password is entered it will request for a new database name . Kindly give the name as "hadoop_class". Once the name is entered it will create database
and create 3 tables as requested in the assignment.


##2. Java Program:

Place the hadoop.java file in any folder under /vagrant. Make sure that the datasets are placed under the folder /vagrant/compfold.
If compfold is not available then please create the folder and place the data sets into the folder. Make sure that the data sets are unzipped before placing it in the folder.

The program will read the data from the datasets , parse it and add entries into the database. Since the data set is large it will take a long time for all the data
to be inserted into the table.

Once all the data is inserted the program will find the maximum temperature and display it to the console.

##3. timecalc program`:

Place the timecalc.java in any folder under /vagrant.
After step 2 is completed run this program to determine the max temperature and time taken for executing the query.

This program will query the database and get the maximum temperature for the 2 tables.
