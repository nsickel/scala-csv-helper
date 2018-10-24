package com.nsickel.csv

import scala.collection.mutable.LinkedHashSet

object CsvHelper extends App {

  val mode = args(0)

  def readFileLines(pathToFile:String) : LinkedHashSet[String] = {
    val linesCsvFile = new LinkedHashSet[String]
    val bufferedSource = io.Source.fromFile(pathToFile)
    for (line <- bufferedSource.getLines) {
      linesCsvFile.add(line)
    }
    bufferedSource.close
    linesCsvFile
  }

  if (mode.equals("filter-unique")) {
    val linesCsvFileOne = readFileLines(args(1))
    val linesCsvFileTwo = readFileLines(args(2))

    linesCsvFileTwo.foreach(line => if (!linesCsvFileOne.contains(line)) println(line))
  }
}


