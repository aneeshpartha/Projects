Item-two - MySQL
----------------

Mysql is installed in the previous assignements. Hence proceeding with the data loading in mysql .

Before loading the data we need to create tables both for large and small weblogs .

Query for creatig the table :

create table weblog( date varchar(50), time varchar(50), s_ip varchar(50),cs_method varchar(50), cs_uri_stem varchar(50), cs_uri_query varchar(50), s_port int, cs_username varchar(50), c_ip varchar(50), cs_user_agent varchar(50), sc_status varchar(50), sc_substatus varchar(50), sc_win32_status varchar(50), time_taken varchar(50) );


create table weblogsmall( date varchar(50), time varchar(50), s_ip varchar(50),cs_method varchar(50), cs_uri_stem varchar(50), cs_uri_query varchar(50), s_port int, cs_username varchar(50), c_ip varchar(50), cs_user_agent varchar(50), sc_status varchar(50), sc_substatus varchar(50), sc_win32_status varchar(50), time_taken varchar(50) );


We can use the below command for loading the data into mysql database

load data local infile '/vagrant/weblogs/2016/2016' into table weblogsmall columns terminated by ' ' lines terminated by '\n';

Reference - https://dev.mysql.com/doc/refman/5.7/en/loading-tables.html

when we use the above command in mysql we will be getting the below error 

This can be avoided by using the below command for logging in 

mysql -u root -p --local-infile

Reference http://stackoverflow.com/questions/18437689/error-1148-the-used-command-is-not-allowed-with-this-mysql-version

Query
-----

**Date :weblog**

select date,cs_uri_stem,max(counts) from ( select date, cs_uri_stem , count(cs_uri_stem) as counts , count(cs_uri_stem) from weblog where 
cs_uri_stem NOT LIKE '/' and cs_uri_stem NOT LIKE '%index%' and sc_status like '200' group by cs_uri_stem , date ) as webs 
group by date  order by date;

**Month:weblog**

select month,cs_uri_stem,max(counts) from ( select substring(date,1,7) as month, cs_uri_stem , count(cs_uri_stem) as counts , count(cs_uri_stem) from weblog where 
cs_uri_stem NOT LIKE '/' and cs_uri_stem NOT LIKE '%index%' and sc_status like '200' group by cs_uri_stem , month) as websmonth
group by month order by month;


**Month : weblogsmall**

select month,cs_uri_stem,max(counts) from ( select substring(date,1,7) as month, cs_uri_stem , count(cs_uri_stem) as counts , count(cs_uri_stem) from weblogsmall where 
cs_uri_stem NOT LIKE '/' and cs_uri_stem NOT LIKE '%index%' and sc_status like '200' group by cs_uri_stem , month) as websmonth
group by month order by month;


**Date : weblogsmall**

select date,cs_uri_stem,max(counts) from ( select date, cs_uri_stem , count(cs_uri_stem) as counts , count(cs_uri_stem) from weblog where 
cs_uri_stem NOT LIKE '/' and cs_uri_stem NOT LIKE '%index%' and sc_status like '200' group by cs_uri_stem , date ) as webs 
group by date  order by date;

Loading data into table :


load data local infile '/vagrant/weblogs/2016/2016' into table weblog columns terminated by ' ' lines terminated by '\n';

load data local infile '/vagrant/weblogs/20152014/20152014' into table weblogsmall columns terminated by ' ' lines terminated by '\n';



Screenshots:

![4](https://cloud.githubusercontent.com/assets/17997235/25560269/7c22a158-2d15-11e7-847b-b33a61820d36.JPG)

![5](https://cloud.githubusercontent.com/assets/17997235/25560270/7c2313d6-2d15-11e7-9c25-9f6535e71db5.JPG)

![6](https://cloud.githubusercontent.com/assets/17997235/25560268/7c224d8e-2d15-11e7-85b8-e95adb6ff46b.JPG)

![7](https://cloud.githubusercontent.com/assets/17997235/25560272/7c2b8944-2d15-11e7-95a1-6b6a5e9f731e.JPG)

![8](https://cloud.githubusercontent.com/assets/17997235/25560271/7c2ae05c-2d15-11e7-9cd8-efdda3b43d0a.JPG)

![9](https://cloud.githubusercontent.com/assets/17997235/25560275/7c2cbc9c-2d15-11e7-9814-2b40836703fd.JPG)

![10](https://cloud.githubusercontent.com/assets/17997235/25560274/7c2c70b6-2d15-11e7-8efc-6b19c2c178a3.JPG)

![11](https://cloud.githubusercontent.com/assets/17997235/25560340/eb6babd0-2d16-11e7-9423-aee44139144c.JPG)


![13](https://cloud.githubusercontent.com/assets/17997235/25560343/eb6d2212-2d16-11e7-8087-a9e0cf3b65a5.JPG)

![14](https://cloud.githubusercontent.com/assets/17997235/25560344/eb6d2fb4-2d16-11e7-90ef-a254db99d8a9.JPG)

![15](https://cloud.githubusercontent.com/assets/17997235/25560342/eb6cb94e-2d16-11e7-8803-37d2d8918d5d.JPG)
