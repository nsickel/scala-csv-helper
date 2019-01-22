package com.nsickel.csv

object CliCommands {

  val ModeFilterUnique = "filter-unique"

  val ModeRemoveDuplicates = "remove-duplicates"

  val ModeMergeFiles = "merge-files"

  val ModeFilterField = "filter-field"

  val ModeRemoveField = "remove-field"

  def printHelpText() = {
    println("program can be used in following ways:")
    println("command\t\t\tparameters\t\t\tscope")
    println(ModeRemoveDuplicates + "\t<pathFile>\t\t\tremoves duplicated entries in a file")
    println(ModeFilterUnique + "\t\t<pathFileOne> <pathFileTwo>\tcompares two files and returns unique lines")
    println(ModeMergeFiles + "\t\t<pathFileOne> <pathFileTwo>\tmerge two files to unique lines")
    println(ModeFilterField + "\t\t<pathFile> <separator> <fieldName>\tfilter a single field out of csv")
    println(ModeRemoveField + "\t\t<pathFile> <separator> <fieldName>\tremove a single field from csv")
  }
}
