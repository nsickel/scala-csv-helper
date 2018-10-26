package com.nsickel.csv

object CsvHelper extends App {

  var mode = args(0)
  val csvReader = new CsvReader

  mode match {
    case CliCommands.ModeFilterUnique =>
      csvReader.printUniqueLinesToComparedFile(args(1),args(2))
    case CliCommands.ModeRemoveDuplicates =>
      csvReader.printFileWithoutDuplicates(args(1))
    case _ =>
      CliCommands.printHelpText()
  }
}


