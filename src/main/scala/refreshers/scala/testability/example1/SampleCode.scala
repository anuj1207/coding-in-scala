package refreshers.scala.testability.example1

import refreshers.scala.testability.example1.Util.Reader

class SampleCode {
  def readAndExecuteData: String = {
    val reader = new Reader
    val data = reader.readFile("sample/path")
    process(data)
  }

  private def process(data: String): String = {
    data
    //Intense processing
  }
}