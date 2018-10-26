package com.nsickel.csv

import scala.collection.mutable.LinkedHashSet

class CsvReader {

  def readFileLines(pathToFile:String) : LinkedHashSet[String] = {
    val linesCsvFile = new LinkedHashSet[String]
    val bufferedSource = io.Source.fromFile(pathToFile)
    for (line <- bufferedSource.getLines) {
      linesCsvFile.add(line)
    }
    bufferedSource.close
    linesCsvFile
  }

  def printUniqueLinesToComparedFile(pathToFileOne:String, pathToFileTwo:String) = {
    val linesCsvFileOne = readFileLines(pathToFileOne)
    val linesCsvFileTwo = readFileLines(pathToFileTwo)
    linesCsvFileTwo.foreach(line => if (!linesCsvFileOne.contains(line)) println(line))
  }

  def printFileWithoutDuplicates(pathToFile:String)= {
    val linesCsvFileOne = readFileLines(pathToFile)
    linesCsvFileOne.foreach(line => println(line))
  }
}
