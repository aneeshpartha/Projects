Item-two
---------

Four operations need to be performed 

1.Calculate Max and Min temperature for each year
2.Calculate average of the per year Max and Min temperatures 
3.Calculate median temperature per year
4.Calculate Std deviation

**1. Max and Min temperature for each year**

Provided dataset 80-99 contains many malformed data.Hence the Maxtemperature job provided in the textbook need to be modified to ignore the malformed data and take into consideration only data which is valid.  The entire code is attached in github.


Note : Forgot to take screenshot of the output before the cluster was restarted . Hence providing the last 4 digits of job_id for reference.

Dataset       |  Time     | Map   | Reduce    | Job_id
--------------|-----------|-------|-----------|---------
80-90.txt     | 1hr 18mins|1264   | 1         | 1289
80-90.txt.bz2 | 1hr 51mins|93     | 1         | 1290
80-90.txt.gz  | 4hr 22mins|1      | 1         | 1292

![1](https://cloud.githubusercontent.com/assets/17997235/25072311/97118ed2-2290-11e7-8185-538e85b5adac.JPG)

**Logic**

![maxmin_logic](https://cloud.githubusercontent.com/assets/17997235/25072316/9716413e-2290-11e7-8990-7ec34d6e0625.JPG)


**2. Average of the per year max and min temperatures**

In this step the maximum and minimum of the previous step is taken and average is calculated. 


Dataset       |  Time     | Map   | Reduce    | Job_id
--------------|-----------|-------|-----------|---------
80-90.txt     | 1hr 35mins|1264   | 1         | 1294
80-90.txt.bz2 | 2hr 4mins |93     | 1         | 1297
80-90.txt.gz  | 2hr 30mins|1      | 1         | 1299

![2](https://cloud.githubusercontent.com/assets/17997235/25072312/97131edc-2290-11e7-890b-0cbf7644feb7.JPG)

**Logic**

![avg_logic](https://cloud.githubusercontent.com/assets/17997235/25072314/97141508-2290-11e7-9887-a5fa5837832c.JPG)

**3.Median Temperature per year**

Before median is calculated the data must be sorted for each year. This is performed in the reducer of the MR program. Map phase deals with ignoring malformed data and extracting only the required columns of the temperature data set.


Dataset       |  Time     | Map   | Reduce    | Job_id
--------------|-----------|-------|-----------|---------
80-90.txt     | 1hr 23mins|1264   | 1         | 1303
80-90.txt.bz2 | 1hr 7mins |93     | 1         | 1304
80-90.txt.gz  | 3hr 3mins |1      | 1         | 1305

![3](https://cloud.githubusercontent.com/assets/17997235/25072313/97137ac6-2290-11e7-886c-507e9edbbaa6.JPG)

**Logic**

![median_logic](https://cloud.githubusercontent.com/assets/17997235/25072317/971c126c-2290-11e7-964a-4fcb4acc5196.JPG)

**4.Standard deviation**


Standard deviation formulae must be applied to the result.

Math.sqrt(square+Math.pow((arr.get(i)-avg),2)/size)


Dataset       |  Time     | Map   | Reduce    | Job_id
--------------|-----------|-------|-----------|---------
80-90.txt     | 2hr 48mins|1264   | 1         | 1308
80-90.txt.bz2 | 1hr 40mins|93     | 1         | 1306
80-90.txt.gz  | 4hr 49mins|1      | 1         | 1307

![4](https://cloud.githubusercontent.com/assets/17997235/25072315/97153f6e-2290-11e7-99bf-80403ac7a7db.JPG)

**Logic**

![std_logic](https://cloud.githubusercontent.com/assets/17997235/25072318/971d6a22-2290-11e7-81f8-5dd0151fda8e.JPG)
