package com.knoldus.test


  import java.io.File

  import com.knoldus.controller.FileHandling
  import org.scalatest._

  class FileHandlingSpec extends FlatSpec with BeforeAndAfterAll {


    var fileHandlingObj: FileHandling = new FileHandling

    override def beforeAll(): Unit = {
      fileHandlingObj  = new FileHandling
    }

    override def afterAll(): Unit = {
      if (fileHandlingObj!= null) {
        fileHandlingObj = null
      }
    }
    val pathObj = new File("/home/knoldus/Downloads/logfiles")
    val filesOrFoldersList = pathObj.listFiles().toList
    val filesList = fileHandlingObj.checkFile(filesOrFoldersList)
    val contenWithFileName = fileHandlingObj.readFile(filesList)

    "readError" should "read error from file" in {
      val actualResult = fileHandlingObj.readError(contenWithFileName)
      val expectedResult = List(("stdout",0), ("stdout1",0), ("stdout5",0), ("stdout 2",0), ("stdout 3",0))
      assert(expectedResult == actualResult)
    }
    "averageWarnings" should "read averageWarnings from file" in {

      val warnings = fileHandlingObj.readWarnings(contenWithFileName)
      val actualResult = fileHandlingObj.averageWarnings(warnings)
      val expectedResult = 1454
      assert(expectedResult == actualResult)
    }
    "readWarnings" should "read Warnings from file" in {
      val actualResult = fileHandlingObj.readWarnings(contenWithFileName)
      val expectedResult = List(("stdout",1454), ("stdout1",1454), ("stdout5",1454), ("stdout 2",1454), ("stdout 3",1454))
      assert(expectedResult == actualResult)
    }
    "readInfo" should "read info from file" in {
      val actualResult = fileHandlingObj.readInfo(contenWithFileName)
      val expectedResult = List(("stdout",256), ("stdout1",256), ("stdout5",256), ("stdout 2",256), ("stdout 3",256))
      assert(expectedResult == actualResult)
    }



  }
