/**
  * Created by Aneesh Partha on 2/10/2018.
  */

import scala.io.Source
import java.io.PrintWriter
import java.io.File
import java.io._

object  youtubeanalytics extends Application {


    def filter(data: Iterator[String]) = {
    val filter1 = data.drop(1)

    val filter2 = filter1.filter(rec => rec.startsWith("\\n") == false)

    val filter3 = filter2.filter(rec => rec.startsWith("http") == false)

    val filter4 = filter3.filter(rec => rec.contains(",") == true)

    val filter5 = filter4.filter(rec => rec.startsWith(" ") == false)

    val filter6 = filter5.filter( rec => rec.split(",")(0).length == 11)

    val filter7 = filter6.filter( rec => (rec.count(_ == ',') == 15))
    
    filter7
  }



  def process(data: Iterator[String]) = {

       val process1 = data.map(rec => {

       val d = rec.split(",")
      (d(1), d(7).toInt, d(0), d(2), d(3), d(8), d(9))
    })


      val process2 = process1.toSeq.sortBy((rec => (rec._1,rec._2))).reverse


      val process3 = process2.groupBy( rec => (rec._1))

      process3

  }

  val srcfile = Source.fromFile("G:\\Datasets\\youtube\\FRvideos\\FRvideos.csv")("UTF-8").getLines()
  val filtereddata = filter(srcfile)
  val processeddata = process(filtereddata)

}


