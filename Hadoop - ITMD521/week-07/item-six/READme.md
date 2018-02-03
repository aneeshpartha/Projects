**Decomposed Map Reduce and Chaining**

**90-93**

Dataset  | Total time of whole job WithoutCombiner | WithCombiner
-------  | --------------------------------------- | ------------
Text     | 25.16                                   | 16.2
gz       | 36.55                                   | 17.46
bz2      | 47.58                                   | 12.14


**Chaining**

Dataset  | Total time
-------  | ----------
Text     | 25.59
gz       | 32.24
bz2      | 26.21


**Without chaining**


![20](https://cloud.githubusercontent.com/assets/17997235/24328307/5d4a40ea-11ab-11e7-8273-d021732a7338.JPG)

**Chaining**


![21](https://cloud.githubusercontent.com/assets/17997235/24328378/c5baf87a-11ad-11e7-85ac-575e7caed240.JPG)

As we can see from the data that the value has decreased for the chaining . Though the value is not huge enough but there is decrease in the value . We have a great decrease almost by 50 percent for data which is bz2 compressed. Chaining reduces the amount of data which needs to be processed by a single mapper . Hence it decreases the processing time of the data. In chaining output is directly passed as a input to other mapper. 
