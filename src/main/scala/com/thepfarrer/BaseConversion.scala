package com.thepfarrer

import scala.annotation.tailrec

object BaseConversion {

  @tailrec
  def toBinary(num: BigInt, acc: String): String =
    if (num < 2) num.toString() + acc
    else
      toBinary(num / 2, (num % 2).toString() + acc)

  def toNoneDecimal(num: Int, base: Int): String =
    Iterator
      .iterate(num)(_ / base)
      .takeWhile(_ > 0)
      .map(_ % base)
      .map {
        case 10 => "A"
        case 11 => "B"
        case 12 => "C"
        case 13 => "D"
        case 14 => "E"
        case 15 => "F"
        case n  => n.toString
      }
      .toList
      .reverse
      .mkString("")

  def toDecimal(num: String, base: Int): String =
    num.reverse.map {
      case 'A' | 'a' => 10
      case 'B' | 'b' => 11
      case 'C' | 'c' => 12
      case 'D' | 'd' => 13
      case 'E' | 'e' => 14
      case 'F' | 'f' => 15
      case n         => n - '0'
    }.zipWithIndex.map { case (x, y) =>
      x * math.pow(base, y)
    }.sum.toInt.toString

  def decimalToHexadecimal(x: Decimal): Hexadecimal =
    Hexadecimal(toNoneDecimal(x.number.toInt, 16))

  def hexadecimalToDecimal(x: Hexadecimal): Decimal =
    Decimal(toDecimal(x.number, 16))

  def decimalToOctal(x: Decimal): Octal =
    Octal(toNoneDecimal(x.number.toInt, 8))

  def hexadecimalToDecimal(x: Octal): Decimal =
    Decimal(toDecimal(x.number, 8))

  def binaryToDecimal(x: Binary): Decimal =
    Decimal(toDecimal(x.number, 2))

  def decimalToBinary(x: Decimal): Binary =
    Binary(toBinary(BigInt(x.number), ""))

}
