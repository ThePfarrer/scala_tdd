package support.steps

import com.thepfarrer.{BaseConversion, Binary, Decimal, Number}

class BaseCoversionSteps extends BaseSteps {
  var baseFrom: Option[Number] = None
  var baseTo: Option[Number] = None

  Given("""^I have a (binary|decimal) number (\d+)$""") { (x: String, baseFromNumber: String) =>
    baseFrom = Some(if (x == "binary") Binary(baseFromNumber) else Decimal(baseFromNumber))
  }

  When("""^I convert it to (binary|decimal) using the BaseConversion utility$""") { (x: String) =>
    baseTo = Some(if (x == "binary") BaseConversion.decimalToBinary(baseFrom.get) else BaseConversion.binaryToDecimal(baseFrom.get))
  }

  Then("""^I get back a (binary|decimal) number (\d+)$""") { (x: String, expected: String) =>
    baseTo.get.number shouldBe expected
  }

}
