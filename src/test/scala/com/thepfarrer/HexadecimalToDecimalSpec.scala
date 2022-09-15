package com.thepfarrer

class HexadecimalToDecimalSpec extends UnitSpec {
  "base conversion utility" should "convert hexadecimal number AB to decimal equivalent 171" in {
    val decimal: Decimal = BaseConversion.hexadecimalToDecimal(Hexadecimal("AB"))
    decimal.number shouldEqual "171"
  }

  it should "convert hexadecimal number 123AB to decimal equivalent 74667" in {
    val decimal: Decimal = BaseConversion.hexadecimalToDecimal(Hexadecimal("123AB"))
    decimal.number shouldBe "74667"
  }

  it should "convert hexadecimal number ABCDEF to decimal equivalent 11259375" in {
    val decimal: Decimal = BaseConversion.hexadecimalToDecimal(Hexadecimal("ABCdEF"))
    decimal.number should equal("11259375")
  }
}
