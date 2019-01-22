package com.nsickel.csv

import scala.collection.mutable
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

  def readFileIndexedByFiledName(pathToFile:String, separtor:String) = {
    val linesCsvFile = new mutable.LinkedHashSet[Array[String]]
    val bufferedSource = io.Source.fromFile(pathToFile)
    for (line <- bufferedSource.getLines) {
      val cols = line.split(separtor).map(_.trim)
      linesCsvFile.add(cols)
    }
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

  def mergeFiles(pathToFileOne:String, pathToFileTwo:String) = {
    val linesCsvFileOne = readFileLines(pathToFileOne)
    val linesCsvFileTwo = readFileLines(pathToFileTwo)

    linesCsvFileTwo.foreach(line => linesCsvFileOne.add(line))
    linesCsvFileOne.foreach(line => println(line))
  }

  def filterField(pathToFile:String, separator:String, fieldName:String) = {
    val linesCsvFile = readFileIndexedByFiledName(pathToFile,separator)
    val lineOne = linesCsvFile.iterator.next();
    val indexFiledToFilter = lineOne.indexOf(fieldName);
    if (indexFiledToFilter >= 0) {
      linesCsvFile.foreach(line => println(line.apply(indexFiledToFilter)))
    } else {
      println("field: " + fieldName + " not found in file:" + pathToFile)
    }
  }

  def removeField(pathToFile:String, separator:String, fieldName:String) = {
    val linesCsvFile = readFileIndexedByFiledName(pathToFile,separator)
    val lineOne = linesCsvFile.iterator.next();
    val indexFiledToFilter = lineOne.indexOf(fieldName);
    if (indexFiledToFilter >= 0) {
      linesCsvFile.foreach(
        line => {
          val columns = line.patch(indexFiledToFilter,Nil,1)
          println(columns.mkString(separator))
        }
      )
    } else {
      println("field: " + fieldName + " not found in file:" + pathToFile)
    }
  }
}
