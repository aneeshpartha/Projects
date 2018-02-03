
#Instructions

#Step 1 : Clone the repository 

git clone https://github.com/illinoistech-itm/apartha.git

#Step 2 : Create a input directory in the hadoop file system

hadoop fs -mkdir -p /user/$USER/week05/input

#Step 3 : Copy the source files to input folder in hadoop system

hadoop fs -copyFromLocal clonedirectory/apartha/ITMD521/week-05/textfiles/* /user/$USER/week05/input

#Step 4 : Execute wordcount1 and wordcount2 program

a)cd clonedirectory/apartha/ITMD521/week-05/code

b)hadoop com.sun.tools.javac.Main *.java

c)jar cf wc.jar *.class

#WordCount1 :

Hadoop jar wc.jar WordCount1 /user/$USER/week05/input /user/$USER/week05/output

#WordCount2 :

Hadoop jar wc.jar WordCount2 /user/$USER/week05/input /user/$USER/week05/output1

#Step 5: Check the output of the program

hadoop fs -cat  /user/$USER/week05/output/part-r-00000 ----> WordCount1

hadoop fs -cat  /user/$USER/week05/output1/part-r-00000 ----> WordCount2

#Step 6: Modify Wordcount 1 to look for only words that occur more than or more than equal to 4 times 

cd clonedirectory/apartha/ITMD521/week-05/modifiedcode

#For words more than 4 times 

cd wordcountmorethan4

hadoop com.sun.tools.javac.Main *.java

jar cf wc.jar *.class

Hadoop jar wc.jar WordCount1 /user/$USER/week05/input /user/$USER/week05/output2

hadoop fs -cat  /user/$USER/week05/output2/part-r-00000

#For Words more than or equal to 4 times 

cd wordcountmorethanequal4

hadoop com.sun.tools.javac.Main *.java

jar cf wc.jar *.class

Hadoop jar wc.jar WordCount1 /user/$USER/week05/input /user/$USER/week05/output3

hadoop fs -cat  /user/$USER/week05/output3/part-r-00000

#Step 7: WordCount2 to skip preposition and punctuation stored in pattern.txt file and turnon lower case option

cd clonedirectory/apartha/ITMD521/week-05/code

hadoop fs -copyFromLocal clonedirectory/apartha/ITMD521/week-05/pattern.txt /user/$USER/week05

Hadoop jar wc.jar WordCount2 -Dwordcount.case.sensitive=true /user/$USER/week05/input /user/$USER/week05/output4 -skip /user/$USER/week05/pattern.txt

hadoop fs -cat /user/$USER/week05/output4/part-r-00000

#Step 8: Top 10 words of each file.

Execute the below command for each file

hadoop fs -cat /user/$USER/week05/output/part-r-00000 | sort -n -r -k2 | head -n 10

hadoop fs -cat /user/$USER/week05/output1/part-r-00000 | sort -n -r -k2 | head -n 10

hadoop fs -cat /user/$USER/week05/output2/part-r-00000 | sort -n -r -k2 | head -n 10

hadoop fs -cat /user/$USER/week05/output3/part-r-00000 | sort -n -r -k2 | head -n 10

hadoop fs -cat /user/$USER/week05/output4/part-r-00000 | sort -n -r -k2 | head -n 10



