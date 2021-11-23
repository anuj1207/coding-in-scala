package refreshers.scala.testability.example1

import refreshers.scala.testability.example1.Util.Reader

object SampleCodeTestable {

  class ThroughDI(reader: Reader) {

    def readAndExecuteData: String = {
      val data = reader.readFile("sample/path")
      process(data)
    }

    def process(data: String): String = {
      data
      //Intense processing
    }

  }

  class ThroughMembership {
    val reader = new Reader //Not a good practice exposing members out of class

    def executeData: String = {
      val data = reader.readFile("sample/path")
      process(data)
    }

    private def process(data: String): String = {
      data
      //Intense processing
    }
  }

}
