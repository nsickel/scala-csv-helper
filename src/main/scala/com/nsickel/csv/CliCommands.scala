package com.nsickel.csv

object CliCommands {

  val ModeFilterUnique = "filter-unique"

  val ModeRemoveDuplicates = "remove-duplicates"

  def printHelpText() = {
    println("program can be used in following ways:")
    println("command\t\t\tparameters\t\t\tscope")
    println(ModeFilterUnique + "\t\t<pathFileOne> <pathFileTwo>\tcompares two files and returns unique lines")
    println(ModeRemoveDuplicates + "\t<pathFile>\t\t\tremoves duplicated entries in a file")
  }
}
