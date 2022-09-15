package com.thepfarrer

class BinaryToDecimalSpec extends UnitSpec {
  "base conversion utility" should "convert a binary number 1001 to a number 9" in {
    val decimal: Decimal = BaseConversion.binaryToDecimal(Binary("1001"))
    assert(decimal.number == "9")
  }

  it should "convert binary number 11110001111110111 to decimal equivalent 123895" in {
    val decimal: Decimal = BaseConversion.binaryToDecimal(Binary("11110001111110111"))
    assert(decimal.number == "123895")
  }

  it should "convert binary number 100000000000001110000001 to decimal equivalent 8389505" in {
    val decimal: Decimal = BaseConversion.binaryToDecimal(Binary("100000000000001110000001"))
    assert(decimal.number == "8389505")
  }
}
