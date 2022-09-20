package com.thepfarrer

import org.scalatest.prop.TableDrivenPropertyChecks

class OctalToDecimalSpec extends UnitSpec with TableDrivenPropertyChecks {
  it should "convert octal to decimal" in {
    val validCombos =
      Table(
        ("1243", "2333"),
        ("11111122", "52305322"),
        ("8389505", "40001601"),
        ("8765432", "41337770")
      )
    forAll(validCombos) { (decString: String, octString: String) =>
      val decimal = BaseConversion.octalToDecimal(Octal(octString))
      decimal.number shouldBe decString
    }
  }

}
