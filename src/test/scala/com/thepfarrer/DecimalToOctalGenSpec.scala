package com.thepfarrer

import org.scalacheck.Gen
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

class DecimalToOctalGenSpec extends UnitSpec with ScalaCheckDrivenPropertyChecks {
  it should "" in {
    val decimals = (for {
      c1 <- Gen.chooseNum(2, 100000)
    } yield c1.toString).suchThat(_ != "")

    forAll(decimals) { (decimalStr: String) =>
      val octal = BaseConversion.decimalToOctal(Decimal(decimalStr))
      val decimal = BaseConversion.octalToDecimal(octal)
      decimal.number shouldBe decimalStr
    }


  }
}
