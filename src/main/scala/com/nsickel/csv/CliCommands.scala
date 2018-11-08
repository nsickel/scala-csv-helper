package com.nsickel.csv

object CliCommands {

  val ModeFilterUnique = "filter-unique"

  val ModeRemoveDuplicates = "remove-duplicates"

  val ModeMergeFiles = "merge-files"

  def printHelpText() = {
    println("program can be used in following ways:")
    println("command\t\t\tparameters\t\t\tscope")
    println(ModeRemoveDuplicates + "\t<pathFile>\t\t\tremoves duplicated entries in a file")
    println(ModeFilterUnique + "\t\t<pathFileOne> <pathFileTwo>\tcompares two files and returns unique lines")
    println(ModeMergeFiles + "\t\t<pathFileOne> <pathFileTwo>\tmerge two files to unique lines")
  }
}
