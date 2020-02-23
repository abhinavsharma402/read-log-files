package com.knoldus.view

import java.io.{File, FileNotFoundException}

import com.knoldus.controller.FileHandling
import com.knoldus.modules._

object Driver extends {
  def main(args: Array[String]): Unit = {


    val pathObj = new File("/home/knoldus/Downloads/logfiles")
    val filesOrFoldersList = pathObj.listFiles().toList
    val fileHandlingobj = new FileHandling
    try {
      val filesList = fileHandlingobj.checkFile(filesOrFoldersList)
      if  (filesList.isEmpty){

        throw new FileNotFoundException("no files in directory")
      }
      else {
        val contenWithFileName = fileHandlingobj.readFile(filesList)
        println("file name, errors " + fileHandlingobj.readError(contenWithFileName))
        val k = fileHandlingobj.readWarnings(contenWithFileName)
        println("file name, warnings " + fileHandlingobj.readWarnings(contenWithFileName))
        println("file name, Info " + fileHandlingobj.readInfo(contenWithFileName))
        println("average warnings " + fileHandlingobj.averageWarnings(k))
      }
    }
    catch {
      case foe: FileNotFoundException => println(foe.getMessage)
      case ex: Exception => println(ex.getMessage)
    }

  }
}
