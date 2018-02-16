/**
  * Created by Aneesh Partha on 2/10/2018.
  */

import scala.io.Source
import java.io.PrintWriter
import java.io.File

object  youtubeanalytics extends Application {


  val srcfile = Source.fromFile("G:\\Datasets\\youtube\\FRvideos.csv\\FRvideos.csv")("UTF-8").getLines()


  val filter1 = srcfile.drop(1)

  val filter2 = filter1.filter(rec => rec.startsWith("\\n") == false)

  val filter3 =  filter2.filter(rec => rec.startsWith("http") == false)

  val filter4 = filter3.filter( rec => rec.contains(",") == false)

  val filter5 = filter4.filter( rec => rec.contains(" ") == false)



  //filter3.take(200).foreach(println)

  val b = filter3.map ( rec => {
    if(rec.contains(",") == true) {
    val d = rec.split(",")
      (d(1),d(7),d(0),d(2),d(3),d(8),d(9))} })

  b.foreach(println)

  //val c = b.toSeq.sortBy((rec => (rec._1,rec._2))).reverse


  //val d = c.groupBy( rec => (rec._1))

//  d.foreach(println)

//dddd val srcfile = Source.fromFile("G:\\Datasets\\youtube\\USvideos\\USvideos.csv")("UTF-8").getLines()
//
//  val headingfilter =  srcfile.drop(1)
//
//  val check = headingfilter.filter( rec => (rec.startsWith("\\n")) == false)
//
//  val data1 = check.map(rec => {
//
//
//      val d = rec.split(",")
//
//      (d(1).toString, d(7), d(0).toString, d(2).toString, d(3).toString, d(8).toString, d(9).toString)
//
//  })
//
// val data2 = data1.toSeq.sortBy( rec => (rec._1,rec._2))
//
// data2.foreach(println)
//
//  //data3.foreach(println)
//
//  // val data3 = data2.map( rec => (rec,1))
//
//
//  // val writer = new PrintWriter(new File("G:\\Datasets\\youtube\\USvideos\\data.csv"))
//
//  // for( line <- data2)
//   //  writer.write(line.toString+"\n")
//
//  // writer.close()
}
