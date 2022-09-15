package com.thepfarrer

import org.scalatest.prop.TableDrivenPropertyChecks

class DecimalToHexadecimalSpec extends UnitSpec with TableDrivenPropertyChecks {
  // Old test method
//  "base conversion utility" should "convert a number 1243 into a hexadecimal number 4DB " in {
//    val hex: Hexadecimal = BaseConversion.decimalToHexadecimal(Decimal("1243"))
//    assert(hex.number == "4DB")
//  }
//
//  it should "convert a number 11111122 into a hexadecimal number A98AD2" in {
//    val hex: Hexadecimal = BaseConversion.decimalToHexadecimal(Decimal("11111122"))
//    assert(hex.number == "A98AD2")
//  }

  // Table Driven Test
  it should "convert decimal to hex" in {
    val validCombos = Table(
      ("1243", "4DB"),
      ("11111122", "A98AD2"),
//      ("2435255412343", "2370088A677"),
      ("8765432", "85BFF8")
    )
    forAll(validCombos) { (decStr: String, hexStr: String) =>
      val hex = BaseConversion.decimalToHexadecimal(Decimal(decStr))
      hex.number shouldBe hexStr
    }
  }
}
