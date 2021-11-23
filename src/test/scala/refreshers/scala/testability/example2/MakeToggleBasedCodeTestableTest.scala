package refreshers.scala.testability.example2

import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.wordspec.AnyWordSpec
import refreshers.scala.testability.example2.Util.FeatureTogglesV2
import refreshers.scala.testability.example2.Util.Types.DataFrame

class MakeToggleBasedCodeTestableTest extends AnyWordSpec {

  val sampleData: DataFrame = "DataFrame"
  val mockedFeatureToggleV2 = mock[FeatureTogglesV2]
  val toggleBasedCode = new MakeToggleBasedCodeTestable.ThroughDI(mockedFeatureToggleV2)

  "MakeToggleBasedCodeTestable through DI" should {
    "be able to test first branch" in {
      when(mockedFeatureToggleV2.enablePushingToKafka).thenReturn(true)
      toggleBasedCode.publish(sampleData)
    }

    "be able to test second branch" in {
      when(mockedFeatureToggleV2.enablePushingToKafka).thenReturn(false)
      toggleBasedCode.publish(sampleData)
    }
  }

}
