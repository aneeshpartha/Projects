#**Week-07 Item-one**

Below gives a detail list of Resources used in the cluster.  The cluster currently has six active nodes.

![Overview](https://cloud.githubusercontent.com/assets/17997235/24322604/af4e5fbe-1135-11e7-8035-f82036b62714.JPG)

Below gives the details of six active nodes which is mapped to the cluster.

![Nodes](https://cloud.githubusercontent.com/assets/17997235/24322603/af4dcd24-1135-11e7-8914-f93439bfa1ba.JPG)

Data set |Total time taken | Map splits | Reduce splits
-------- |---------------- | ---------- | -------------
1990     | 28 mins 28 secs | 63         | 1
90 and 92| 37 mins 27 secs | 132        | 1
90-93    | 45 mins 41 secs | 269        | 1


![time taken](https://cloud.githubusercontent.com/assets/17997235/24322817/51cd5562-1139-11e7-8aa0-e63ecda46020.JPG)

![1](https://cloud.githubusercontent.com/assets/17997235/24323055/e8b07c9e-113d-11e7-80f3-ea63fc774284.png)
![2](https://cloud.githubusercontent.com/assets/17997235/24323056/e8b9107a-113d-11e7-9d13-180febfae235.png)
![3](https://cloud.githubusercontent.com/assets/17997235/24323057/e8bd27d2-113d-11e7-92ce-df6a8490b758.png)

**Why run times of the above mentioned data sets are different ?**

As the size of data increases the number of splits or blocks being stored in HDFS increases. Each block will be processed by a single mapper. Hence the processing time by the MapReduce program is more for bigger data sets . In our excercise 1990 is a small data set compared to 1990and1992 and 90-93 which almost contains more than double and triple of 1990 data set . Hence the time taken by the job also increases. It is not mandatory that the time taken for  processing will also be double and triple for these data sets. 

**How MapReduce takes advantage of distributed cluster?**

Whenever a file is stored in HDFS it is split into blocks. In a distributed cluster all the blocks are not stored and processed by a single data node . Instead the blocks are sent to different nodes for processing . This enables parallel processing. Since the job is being processed in parallel the time taken by the job to complete is less when compared to a standalone machine. All these information regarding block size is tracked by the name node. Also , all the blocks are replicated in a distributed cluster with a default replication factor being 3 . In case of any corrupt block or if there is any issue with any of the data nodes then the other data node immediately takes over and processes the data . This helps in high availability of the data.

The below picture gives details of how an block is handled by each Map and Reduce

![capture2](https://cloud.githubusercontent.com/assets/17997235/24323010/d77ccca8-113c-11e7-8509-f956e0ac2661.JPG)


The below image gives an overview of how an file is written in and HDFS (distributed cluster)

![capture1](https://cloud.githubusercontent.com/assets/17997235/24323015/feb9e760-113c-11e7-9514-dbc34b009223.JPG)
