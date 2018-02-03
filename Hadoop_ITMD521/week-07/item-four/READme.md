**#Intermediate compression**

1990
----

Dataset | WithoutCombiner | WithCombiner 
------- | --------------  | ---------------
1990    | 6.26            | 20.12   
1990bz2 | 20.95           | 8.42
1990gz  | 58.33           | 8.03

![20](https://cloud.githubusercontent.com/assets/17997235/24327723/6842cfd8-119e-11e7-9c5d-e020c66d30e5.JPG)

1990 and 1992
-------------

Dataset | WithoutCombiner | WithCombiner
------- | --------------- | ---------------
90-92   | 35.53           | 30.45 
90-92bz2| 20.41           | 13.22
90-92gz | 15.56           | 11.51

![21](https://cloud.githubusercontent.com/assets/17997235/24327724/684d8c3e-119e-11e7-8224-890345d60469.JPG)

90-93
-----

Dataset | WithoutCombiner | WithCombiner
------- | --------------- | ---------------
90-93   | 42.04           | 22.37
90-93bz2| 25.33           | 19.59
90-93gz | 16.47           | 35.11

![23](https://cloud.githubusercontent.com/assets/17997235/24327740/a7dcc2b6-119e-11e7-9a8a-cbd8d3f8c75c.JPG)

Figure 7-1

![8](https://cloud.githubusercontent.com/assets/17997235/24325536/c589533c-1168-11e7-9a70-1748dc72b2d3.JPG)

The Map output is generally written to disk and it is transferred across network to reducers. When there is  huge amount of data to be transferred it reduces the throughput . Hence it is advantageous to perform a intermeidate compression. Performing intermediate compression using some fast compressor such as LZO or LZ4 will increase the performance since it reduces the amount of data that is written to disk and transferred across the network.This increases the throughput and transfers the data at a faster rate.
