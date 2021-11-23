package refreshers.scala.testability.example2

import refreshers.scala.testability.example2.Util.FeatureTogglesV2
import refreshers.scala.testability.example2.Util.Types.DataFrame

object MakeToggleBasedCodeTestable {

  class ThroughDI(featureTogglesV2: FeatureTogglesV2 = FeatureTogglesV2) {

    def publish(data: DataFrame): Unit = {
      if(featureTogglesV2.enablePushingToKafka) {
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

}
