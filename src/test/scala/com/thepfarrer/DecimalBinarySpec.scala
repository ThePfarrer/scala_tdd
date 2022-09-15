package com.thepfarrer

import org.scalatest.prop.TableDrivenPropertyChecks

class DecimalBinarySpec extends UnitSpec with TableDrivenPropertyChecks {
//  "base conversion utility" should "convert a number 99 into a binary number 1100011" in {
//    val binary: Binary = BaseConversion.decimalToBinary(Decimal("99"))
//    assert(binary.number == "1100011")
//  }
//  it should "convert a number 245 into a binary number 11110101" in {
//    val binary: Binary = BaseConversion.decimalToBinary(Decimal("245"))
//    assert(binary.number == "11110101")
//  }
//  it should "convert a number 3141 into a binary number 110001000101" in {
//    val binary: Binary = BaseConversion.decimalToBinary(Decimal("3141"))
//    assert(binary.number == "110001000101")
//  }

  it should "convert decimal to binary" in {
    val validCombos =
      Table(
        ("100100111101", "2365"),
        ("11110001111110111", "123895"),
        ("100000000000001110000001", "8389505"),
        ("1011110101011101001101", "3102541")
      )
    forAll(validCombos) { (binString: String, decString: String) =>
      val binary = BaseConversion.decimalToBinary(Decimal(decString))
      binary.number shouldBe binString
    }
  }
}
