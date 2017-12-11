package dugger.demo.utils

object ConverterUtils {
  def toLong(longStr: String): Long = { longStr.replaceAll(",", "").toLong }
}
