package com.thepfarrer

trait Number {
  def number: String
  require(
    number.forall(c => c.isDigit || "ABCDEF".contains(c.toUpper)),
    "Unable to convert string to number"
  )
}
case class Decimal(number: String)     extends Number
case class Binary(number: String)      extends Number
case class Octal(number: String)      extends Number
case class Hexadecimal(number: String) extends Number
