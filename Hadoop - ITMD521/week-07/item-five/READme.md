**#Native hadoop compression **


**1990**

Data set | WithoutCombiner | WithCombiner
-------- | --------------- | ------------
1990gz   | 24.41           | 5.13
1990bz2  | 16.67           | 13.27

![20](https://cloud.githubusercontent.com/assets/17997235/24328085/d8d6925a-11a5-11e7-9f5a-994b08b2c44b.JPG)


**90-92**

Data set | WithoutCombiner | WithCombiner
-------- | --------------- | ------------
90-92gz  | 13.34           | 5.13
90-92bz2 | 11.19           | 7.57 

![21](https://cloud.githubusercontent.com/assets/17997235/24328086/d8dec524-11a5-11e7-9b35-d5d7b87c58c9.JPG)

**90-93**

Data set | WithoutCombiner | WithCombiner
-------- | --------------- | ------------
90-93gz  | 42.15           | 15.08
90-93bz2 | 18.11           | 13.54 

![23](https://cloud.githubusercontent.com/assets/17997235/24328087/d8df06e2-11a5-11e7-80e0-cbbf30321b0c.JPG)

Native compression codec shows a drastic increase in performance . As stated in text book page 104 using native gzip compression reduced decompression times by upto 50 percent  and compression times by 10 percent. 


Let us compare the above output with java enabled compression output.

![20](https://cloud.githubusercontent.com/assets/17997235/24327723/6842cfd8-119e-11e7-9c5d-e020c66d30e5.JPG)
![21](https://cloud.githubusercontent.com/assets/17997235/24327724/684d8c3e-119e-11e7-8224-890345d60469.JPG)
![23](https://cloud.githubusercontent.com/assets/17997235/24327740/a7dcc2b6-119e-11e7-9a8a-cbd8d3f8c75c.JPG)

As we can see from the values of both native libraries and java compression that the time has drastically reduced by more than 40 percent. This inturn shows the performance increase in the hadoop. 
