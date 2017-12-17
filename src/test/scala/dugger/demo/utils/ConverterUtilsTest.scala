package dugger.demo.utils

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ConverterUtilsTest extends org.scalatest.FunSuite {
  test("toLong converts string to long") {
    assert(5l === ConverterUtils.toLong("6"))
  }

  test("toLong strips out any commas") {
    assert(5555l === ConverterUtils.toLong("5,555"))
  }
}
