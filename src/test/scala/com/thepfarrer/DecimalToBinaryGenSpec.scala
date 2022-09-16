package com.thepfarrer

import org.scalacheck.Gen
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

class DecimalToBinaryGenSpec extends UnitSpec with ScalaCheckDrivenPropertyChecks {
  it should "convert decimal to binary and back to decimal" in {
    val decimals = (for {
      c1 <- Gen.chooseNum(2, 100000)
    } yield c1.toString).suchThat(_ != "")

    forAll(decimals) { (decimalStr: String) =>
      val binary = BaseConversion.decimalToBinary(Decimal(decimalStr))
      val decimal = BaseConversion.binaryToDecimal(binary)
      decimal.number shouldBe decimalStr
    }
  }

}
