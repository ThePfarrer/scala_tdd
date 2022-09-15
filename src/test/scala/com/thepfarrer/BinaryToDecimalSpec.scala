package com.thepfarrer

import org.scalatest.prop.TableDrivenPropertyChecks

class BinaryToDecimalSpec extends UnitSpec with TableDrivenPropertyChecks {
  // Old test method
//  "base conversion utility" should "convert a binary number 1001 to a number 9" in {
//    val decimal: Decimal = BaseConversion.binaryToDecimal(Binary("1001"))
//    assert(decimal.number == "9")
//  }
//
//  it should "convert binary number 11110001111110111 to decimal equivalent 123895" in {
//    val decimal: Decimal = BaseConversion.binaryToDecimal(Binary("11110001111110111"))
//    assert(decimal.number == "123895")
//  }
//
//  it should "convert binary number 100000000000001110000001 to decimal equivalent 8389505" in {
//    val decimal: Decimal = BaseConversion.binaryToDecimal(Binary("100000000000001110000001"))
//    assert(decimal.number == "8389505")
//  }

  // Table Driven Test
  it should "convert binary to decimal" in {
    val validCombos =
      Table(
        ("100100111101", "2365"),
        ("11110001111110111", "123895"),
        ("100000000000001110000001", "8389505"),
        ("1011110101011101001101", "3102541")
      )
    forAll(validCombos) { (binString: String, decString: String) =>
      val decimal = BaseConversion.binaryToDecimal(Binary(binString))
      decimal.number shouldBe decString
    }
  }
}
