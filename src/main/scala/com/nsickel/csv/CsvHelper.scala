package com.nsickel.csv

object CsvHelper extends App {

  var mode = args(0)
  val csvReader = new CsvReader

  mode match {
    case CliCommands.ModeRemoveDuplicates =>
      csvReader.printFileWithoutDuplicates(args(1))
    case CliCommands.ModeFilterUnique =>
      csvReader.printUniqueLinesToComparedFile(args(1),args(2))
    case CliCommands.ModeMergeFiles =>
      csvReader.mergeFiles(args(1),args(2))
    case CliCommands.ModeFilterField =>
      csvReader.filterField(args(1),args(2), args(3))
    case CliCommands.ModeRemoveField =>
      csvReader.removeField(args(1),args(2), args(3))
    case _ =>
      CliCommands.printHelpText()
  }
}
