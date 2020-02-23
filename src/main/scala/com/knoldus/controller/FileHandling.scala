package com.knoldus.controller

import java.io.File

import com.knoldus.modules.FileOperation

import scala.io.Source

class FileHandling extends FileOperation {
  override def checkFile(filesOrFolder: List[File]): List[File] = {
    filesOrFolder.filter(_.isFile)
  }

  override def readFile(files: List[File]): List[(String, List[String])] = {
    files.map((file => (file.getName, Source.fromFile(file).getLines().toList)))


  }

  override def readError(filesContent: List[(String, List[String])]): List[(String, Int)] = {
    filesContent.map(fileNameOrContent => (fileNameOrContent._1, fileNameOrContent._2.count(_.contains("[ERROR]"))))


  }

  override def readWarnings(filesContent: List[(String, List[String])]): List[(String, Int)] = {

    filesContent.map(fileNameOrContent => (fileNameOrContent._1, fileNameOrContent._2.count(_.contains("[WARN]"))))

  }

  override def readInfo(filesContent: List[(String, List[String])]): List[(String, Int)] = {
    filesContent.map(fileNameOrContent => (fileNameOrContent._1, fileNameOrContent._2.count(_.contains("[INFO]"))))

  }

  override def averageWarnings(warningsCount: List[(String, Int)]): Int = {
    warningsCount.foldLeft(0) { (sum, warningList) => sum + warningList._2 } / warningsCount.length

  }
}
