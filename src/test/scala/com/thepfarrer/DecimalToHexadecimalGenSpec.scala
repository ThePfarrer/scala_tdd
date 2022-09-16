package com.thepfarrer

import org.scalacheck.Gen
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

class DecimalToHexadecimalGenSpec extends UnitSpec with ScalaCheckDrivenPropertyChecks {
  it should "convert decimal to hexadecimal and back to decimal" in {
    val decimals = (for {
      c1 <- Gen.chooseNum(2, 100000)
    } yield c1.toString).suchThat(_ != "")

    forAll(decimals) { (decimalStr: String) =>
      val hexadecimal = BaseConversion.decimalToHexadecimal(Decimal(decimalStr))
      val decimal = BaseConversion.hexadecimalToDecimal(hexadecimal)
      decimal.number shouldBe decimalStr
    }
  }

}


