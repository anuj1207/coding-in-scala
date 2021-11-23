package refreshers.scala.testability.example2

import refreshers.scala.testability.example2.Util.FeatureToggles
import refreshers.scala.testability.example2.Util.Types.DataFrame

class ToggleBasedCode {

  def publish(data: DataFrame): Unit = {
    if(FeatureToggles.enablePushingToKafka) {
      writeDataToKafka(data)
    } else {
      writeDataToFile(data)
    }
  }

  private def writeDataToKafka(dataFrame: DataFrame): Unit = {
    println("code for kafka")
  }

  private def writeDataToFile(dataFrame: DataFrame): Unit = {
    println("code for file")
  }

}
