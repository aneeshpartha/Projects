**MaxTemperature with and without combiner and Matrix of Variables** 

MaxTemperature program is triggered with and without combiners for a set of uncompressed , bz2 compressed and gz compressed data set. 

Below are the results of the data 

Withoutcombiner
---------------

**1990**

Dataset | Total Time taken | Map splits | Reduce splits
------- | ---------------- | ---------- | -------------
1990    | 27 mins 59secs   | 63         | 1
1990bz2 | 15 mins 54 secs  | 5          | 1
1990gz  | 48 mins 33 secs  | 1          | 1


**1990 and 1992** 

Dataset | Total Time taken | Map splits | Reduce splits
------- | ---------------- | ---------- | -------------
90-92   | 37 mins 27 secs  | 132        | 1
90-92bz2| 26 mins 32 secs  | 10         | 1
90-92gz | 1 hr16 min 34sec | 1          | 1

**90-93**

Dataset | Total Time taken | Map splits | Reduce splits
------- | ---------------- | ---------- | -------------
90-93   | 45 mins 41 secs  | 269        | 1
90-93bz2| 46 mins 11 secs  | 20         | 1
90-93gz | 3 hours 14 mins  | 1          | 1

WithCombiner
------------

**1990**

Dataset | Total Time taken | Map splits | Reduce splits
------- | ---------------- | ---------- | -------------
1990    | 1 min 51 secs    | 63         | 1
1990bz2 | 11 mins 16 secs  | 5          | 1
1990gz  | 34 mins 14 secs  | 1          | 1


**1990 and 1992**

Dataset | Total Time taken | Map splits | Reduce splits
------- | ---------------- | ---------- | -------------
90-92   | 12 mins 38 secs  | 132        | 1
90-92bz2| 26 mins 40 secs  | 10         | 1
90-92gz | 33 mins 35 secs  | 1          | 1

**90-93**

Dataset | Total Time taken | Map splits | Reduce splits
------- | ---------------- | ---------- | -------------
90-93   | 27 mins 59 secs  | 269        | 1
90-93bz2| 21 mins 38 secs  | 20         | 1
90-93gz | 3 hours 20 mins  | 1          | 1


**1990**

![10](https://cloud.githubusercontent.com/assets/17997235/24324342/d982e986-1152-11e7-8494-ce6ed650d153.JPG)

**1991 and 1992**

![11](https://cloud.githubusercontent.com/assets/17997235/24324344/d98cdfd6-1152-11e7-93cd-4d97cc05d408.JPG)

**90-93**

![12](https://cloud.githubusercontent.com/assets/17997235/24324343/d98b3ba4-1152-11e7-9865-306a59f1a108.JPG)

**Explanation**

1990 data set is small and it has taken the least time to run when compared to 90-92 and 90-93 . 90-92 data set is larger data set than 1990 but it is small than 90-93 data set . Hence the time difference between the data sets would be respective to the size of data set.

Also the run time of jobs without combiner is more when compared to jobs triggered with combiner. This is due to the optimization which is done in the mapper phase for jobs with combiner.This is similar to item-one and item-two which is already explained .

**Compression**

The job execution time for bz2 is less than gz . This is due to the fact that bz2 supports splitability whereas gz does not support splittability . Gzip format uses DEFLATE to store the compressed data and DEFLATE stores data as a series of compressed blocks .Due to this file which is gz compressed is processed by only one mapper . There is no parallel processing for the files with gz compression . Hence the time taken is more .  Since bz2 supports splittability the input is split into many blocks and there occurs a parallel processing. 

Reference : Text book page 105 
