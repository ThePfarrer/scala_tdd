package com.thepfarrer

class BeanSpec extends UnitSpec {
  "Decimal" should "throw error when initialized with a non numeric string" in {
    try {
      Decimal("xyz")
    } catch {
      case e: IllegalArgumentException =>
        assert(e.getMessage == "requirement failed: Unable to convert string to number")
        `case _ `: Throwable => fail
    }
  }

  "Binary" should "throw error when initialized with a non numeric string" in {
    intercept[IllegalArgumentException](Binary("xyz"))
  }

  "Hexadecimal" should "throw error when initialized with a non numeric string" in {
    intercept[IllegalArgumentException](Hexadecimal("xyz"))
  }

  "Octal" should "throw error when initialized with a non numeric string" in {
    intercept[IllegalArgumentException](Hexadecimal("xyz"))
  }

}
