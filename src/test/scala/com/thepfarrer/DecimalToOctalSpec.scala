package com.thepfarrer

import org.scalatest.prop.TableDrivenPropertyChecks

class DecimalToOctalSpec extends UnitSpec with TableDrivenPropertyChecks {
  it should "convert decimal to octal" in {
    val validCombos = Table(
      ("1243", "2333"),
      ("11111122", "52305322"),
      ("8389505", "40001601"),
      ("8765432", "41337770")
    )
    forAll(validCombos) { (decStr: String, octStr: String) =>
      val oct = BaseConversion.decimalToOctal(Decimal(decStr))
      oct.number shouldBe octStr
    }
  }

}
