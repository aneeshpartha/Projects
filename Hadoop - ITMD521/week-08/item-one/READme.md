Item-one
--------

**Data used :** 90and92-256 and 90-93-256

**1. MaxTemperature without compression on both datasets.**

In this step MaxTemperature job given in the text book is executed using data 1990and1992.txt and 90919293.txt. The dataused as input in this step is stored in a 256mb block size. Increasing the block size from 128mb to 256 mb helps to reduce the memory pressure on the namenode  and gives mapper more work to do. Also it helps in reducing the number of mappers being used.

We can increase the split size by setting the dfs.blocksize or by configuring this on a per-file basis at file construction time. ( Reference  Table 8-6 hadoop text book)


Dataset          | Time       | Map | Reducer
-----------------| -----------|-----|--------- 
1990and1992.txt  | 1hr 11mins | 66  |  1
90919293.txt     | 1hr 31mins | 135 |  1

![1](https://cloud.githubusercontent.com/assets/17997235/25071828/8ff42cae-2286-11e7-951f-782b658665bc.JPG)

**2. MaxTemperature with input compressed**

Here we are giving an bz2 and gz compressed input to the Mapreduce job . Due to the splitability feature of bz2 it is split into number of Mapper jobs . But gz input is sent to only one mapper.


90and92 dataset 

Dataset              |   Time       |   Map     | Reducer 
---------------------|--------------|-----------|--------
1990and1992.txt.bz2  |  1hr 18mins  |  5        |  1
1990and1992.txt.gz   |  14mins 28sec|  1        |  1

![2](https://cloud.githubusercontent.com/assets/17997235/25071832/8ff89ea6-2286-11e7-8e74-50c807b67548.JPG)

90-93 dataset


Dataset          |  Time         |   Map   |  Reducer
-----------------|---------------|---------|----------
90919293.txt.bz2 | 13mins 51secs |  10     |  1
90919293.txt.gz  | 28mins 33secs |  1      |  1

![3](https://cloud.githubusercontent.com/assets/17997235/25071829/8ff7eace-2286-11e7-9134-26346cf8671e.JPG)

**3. MaxTemperature job with input and Map output compressed **


In this step we are performing an intermediate compression on the Map output. This reduces the size of data being stored and transferred to the reducer. Bz2 and gz compressed data is given as the input to the MaxTemperatureMapCompression job.


90and92 dataset 

Dataset              |   Time       |   Map     | Reducer
---------------------|--------------|-----------|--------
1990and1992.txt      |  13mins 45sec|  66       |  1
1990and1992.txt.bz2  |  21mins 1sec |  5        |  1
1990and1992.txt.gz   |  21mins 5sec |  1        |  1

![4](https://cloud.githubusercontent.com/assets/17997235/25071830/8ff80b8a-2286-11e7-9b8d-88069dd66670.JPG)

90-93 dataset

Dataset          |  Time         |   Map   |  Reducer
-----------------|---------------|---------|----------
90919293.txt     | 26mins 49sec  |  135    |  1
90919293.txt.bz2 | 9mins 51secs  |  10     |  1
90919293.txt.gz  | 17mins 15secs |  1      |  1

![5](https://cloud.githubusercontent.com/assets/17997235/25071831/8ff82624-2286-11e7-973c-c30bcebf9bc0.JPG)


**4. MaxTemperature with combiner**

Combiner is used in the mapper phase which reduces the amount of work in the reducer phase. This reduces the amount of time taken for the entire job.

90and92 dataset

Dataset              |   Time       |   Map     | Reducer
---------------------|--------------|-----------|--------
1990and1992.txt      |  17mins 15sec|  66       |  1
1990and1992.txt.bz2  |  24mins 25sec|  5        |  1
1990and1992.txt.gz   |  13mins 58sec|  1        |  1

![6](https://cloud.githubusercontent.com/assets/17997235/25071833/8ff9922a-2286-11e7-94f0-125cfd0b2b1f.JPG)

90-93 dataset

Dataset          |  Time         |   Map   |  Reducer
-----------------|---------------|---------|-----------
90919293.txt     | 23mins 42sec  |  135    |  1
90919293.txt.bz2 | 33mins 2secs  |  10     |  1
90919293.txt.gz  | 16mins 30secs |  1      |  1

![7](https://cloud.githubusercontent.com/assets/17997235/25071834/8ffde762-2286-11e7-835d-dd879e5016e3.JPG)





























