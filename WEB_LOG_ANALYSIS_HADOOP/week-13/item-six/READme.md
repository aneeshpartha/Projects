Item-Six
t
--------

**Comparison and contrast between different elements of Hadoop :**

Below are the components used in this project 


1.MAPREDUCE
2.SQL
3.SQOOP
4.PIG
5.HIVE

MAPREDUCE:
----------

Mapreduce is one of the good options when complex processing is required. The drawback of Mapreduce is writing complex programs .People who are not good at java will face difficulty when writing programs in MapReduce.But the advantage of MapReduce is that since it has Map and Reduce phase we can determine the type of output extracted from the program. We can also try to reduce the time taken for execution by adding multiple combiners to MR. One of the advantages of MR job is that it sorts the output without mentioning it explicitly. Once program is written it is easy to run it multiple times as we are going to only change the input and output fields . Sometimes input and outputs are also specified in the program itself. It is just a write once use many times model. Except programming complexity MR is a mechanism to use for data sets.

SQL:
----

People who love SQL will enjoy it as querying is simpler than programming . In this excercise if data is already loaded in the database we need to write just 2 or 3 lines of query to fetch the output. But loading the data into strutured database is a tedious process as we need to first clean the data before sending it to the database. It is also required to mention the delimiter for the data which is difficult in the unstrucutured data world. Also when data is huge writing less optimal query consumes a lot of time. Writing a java program to load data into databases also take hours sometimes days. For example , in this excercise if we write a java program to load the data into SQL then it would take more than 6 hours to completely inject the data. Load command haden taken only 15 mins to inject the entire data. Hence it is wise to use SQL depending on the situation.

SQOOP:
------

Sqoop gives a great flexibility to import data from databases and run jobs on it . It is one of the best ways to work with databases. Once data is loaded from database sqoop acts similar to MapReduce as we need to write Mapreduce programs for processing the data. Since programming comes into place we again have the problem of writing complex codes . For example this excercise took more than 11 hours for coding and debugging the sqoop program . Also until we run the entire program we do not know if there are any malformed data in the whole dataset . If yes then we must again modify codes to ignore it. This is advantage in SQL queries as it would throw error as soon as the query is submitted . Hence  sqoop is a better option if we need to simultaneously work both with  database and processing of data.


PIG:
----

Pig can be written in pig latin or can be executed in a interactive grunt environment similar to way the SQL queries are executed. It is simple like SQL but offers better functionality for large datasets when compared to SQL . Pig converts the tranformations in Mapreduce jobs in the backend. We need not worry about writing a complex program. The speciality of Pig is that it allows us to process large amount of data in just a  couple of lines of Pig latin. If a SQL query is written then we can easily convert it to a pig latin. We need to just know the keywords used in pig latin. For example where clause in SQL is FILTER clause in pig latin and GROUP clause in SQL is same GROUP in pig . In this excercise we have loaded the data from a text file into PIG and written transformation based on the loaded data. A dump command will push the transformation into execution and generate the results.

HIVE:
-----
Hive accesses the data from HDFS. Hence data must be available in HDFS before we start to work with HIVE. It is similar to writing SQL
 queries but here we will be executing the queries from HIVE shell. In this excercise we can make use of the query which we used in st
ep 2 (SQL) . We need to perform only few modifications in the query in order to work with HIVE. HIVE is nothing but a framework for da
tawarehouse which is great for analytic purposes . It is difficult to perform complex operations with HIVE but it is a descent resourc
e for loading a data and working as in SQL.


Personal choice:
----------------

I would prefer to use sqoop as it gives me the freedom to access the database as well as write programs to process the data. Though SQL is easy to use and understand it does not provide a great support when used for complex datas. Hence only a program would be a good fit for processing the data. In the current world most of the information are stored only in databases . Hence it is essential that we can access the database all time . Since sqoop gives us that oppurtunity i would prefer it inspite of the tediousness in writing a program. 

In case if the data is simple i would like to work in HIVE as it gives me freedom to use sql kind of analysis.


