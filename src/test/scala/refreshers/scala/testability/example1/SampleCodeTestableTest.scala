package refreshers.scala.testability.example1

import org.mockito.Mockito.when
import org.mockito.MockitoSugar.mock
import org.scalatest.wordspec.AsyncWordSpec
import refreshers.scala.testability.example1.Util.Reader

class SampleCodeTestableTest extends AsyncWordSpec {

  val mockedReader: Reader = mock[Reader]

  "MakeItTestable ThroughDI" should {
    val throughDI = new SampleCodeTestable.ThroughDI(mockedReader)
    "be able to mock reader" in {
      val sampleData = "data"
      when(mockedReader.readFile("sample/path")).thenReturn(sampleData)
      assert(sampleData == throughDI.readAndExecuteData)
    }
  }

  "MakeItTestable ThroughMember" should {
    val throughMembership = new SampleCodeTestable.ThroughMembership {
      override val reader: Reader = mockedReader
    }
    "be able to mock reader" in {
      val sampleData = "data"
      when(mockedReader.readFile("sample/path")).thenReturn(sampleData)
      assert(sampleData == throughMembership.executeData)
    }
  }

}
