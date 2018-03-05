/**
  * Created by Aneesh Partha on 2/10/2018.
  */

import scala.io.Source
import java.io.PrintWriter
import java.io.File
import java.io._
import scala.collection.immutable

object  youtubeanalytics extends App {

  try {
    def filter(data: Iterator[String]) = {

      val filter1 = data.drop(1)

      val filter2: Iterator[String] = filter1.filter(rec => rec.startsWith("\\n") == false)

      val filter3 = filter2.filter(rec => rec.startsWith("http") == false)

      val filter4 = filter3.filter(rec => rec.contains(",") == true)

      val filter6 = filter4.filter(rec => rec.split(",")(0).length == 11)

      val filter7: Iterator[String] = filter6.filter(rec => (rec.count(_ == ',') == 15))

      filter7
    }


    def process(data: Iterator[String]) = {


      val b = data.map(rec => {

        val d = rec.split(",")
        (d(1), d(7).toInt, d(0), d(2), d(3), d(8), d(9))
      })


      val c = b.toSeq.sortBy((rec => (rec._1, rec._2))).reverse


      val d: Map[String, Seq[(String, Int, String, String, String, String, String)]] = c.groupBy(rec => (rec._1))

      d


    }

    val srcfile = Source.fromFile(args(0))("UTF-8").getLines()
    val filtereddata = filter(srcfile)
    val processeddata = process(filtereddata)

    println("Date" + "\t" + "No of views" + "\t" + "Video_id" + "\t" + "channel" + "\t\t\t" + "Description" + "\t" + "likes")

    val data = processeddata.map(rec => rec._2(0)).map(rec => (rec._1 + "\t" + rec._2 + "\t" + rec._3 +
      "\t" + rec._4 + "\t\t\t" + rec._5 + "\t" + rec._6 + "\t" + rec._7))

    data.foreach(println)
  }
  catch
  {
    case num:NumberFormatException => print("There is a number format exception")
  }
}

