##**MaxTemperature with Combiner**

**What is Combiner ?** 

Combiner is a combination of mapper and reducer in the map side. This gives an advantage of reduced workload in the reducer side as the output from Map side is already sorted. This also reduces the amount of time taken to process by reducer .


With Combiner
-------------

Data set |Total time taken | Map splits | Reduce splits
-------- |---------------- | ---------- | -------------
1990     | 1 min 51 secs   | 63         | 1
90 and 92| 12 mins 38 secs | 132        | 1
90-93    | 27 mins 59 secs | 269        | 1

![4](https://cloud.githubusercontent.com/assets/17997235/24323197/4c953f90-1140-11e7-9959-e13a3a256d8c.JPG)

1990
----

![5](https://cloud.githubusercontent.com/assets/17997235/24323216/90d58eda-1140-11e7-976a-5594a1c42fdb.png)

1990-92
-------
![6](https://cloud.githubusercontent.com/assets/17997235/24323217/90d84756-1140-11e7-9d95-26b324101233.png)


90-93
-----
![7](https://cloud.githubusercontent.com/assets/17997235/24323218/90dcda00-1140-11e7-91ee-7e5f3816068a.png)


As we can see the time taken by the job has drastically reduced after using combiner . Running a combiner makes for a more compact map output. This helps in reducing the amount of data return to the disk and inturn the data which is being transferred to the reducer. Depending on optimization a combiner is triggered zero or more times . But running a combiner multiple times does not change the reducer output.

Figure-7.1 hadoop text book

![8](https://cloud.githubusercontent.com/assets/17997235/24323430/1170eda8-1143-11e7-9b6f-8b63ff772f03.JPG)


When a job is initially submitted the resource manager requests the node manager to allocate resources for the job . Based on the availability each node allocates resources for the job. Once resource is available each node starts a application manager dedicated for each job. The control is handed over to application manager to take over the job.If the file ismall the job is executed in the same node . If the file size if large then it requests other node managers for job storeage and processing . The application manager then runs the Map task with combiner . The Map tasks generates a output which is then sorted and combined using combiner . Here the size of the map output is optimized and this output is written to the disk when a certain amount of threshold is reached. This output from the disk is later sent to reducer . This is shown in step 10 "retrieve job resources" from shared file system. 
The time to store into the file system and then retrieve from the file system is reduced which reduces the overall time of the MR job. That is the reason the time of the second item has decreased when compared to the first item.

