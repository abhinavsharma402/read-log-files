package com.knoldus.modules

import java.io.File

trait FileOperation {
  def checkFile(files: List[File]): List[File]

  def readFile(files: List[File]): List[(String, List[String])]

  def readError(filesContent: List[(String, List[String])]): List[(String, Int)]

  def readWarnings(filesContent: List[(String, List[String])]): List[(String, Int)]

  def readInfo(filesContent: List[(String, List[String])]): List[(String, Int)]

  def averageWarnings(warningsCount: List[(String, Int)]): Int
}


