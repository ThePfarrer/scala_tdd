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
      case n => n - '0'
    }.zipWithIndex.map { case (x, y) =>
      x * math.pow(base, y)
    }.sum.toInt.toString

  def decimalToHexadecimal(decimal: Number): Hexadecimal =
    Hexadecimal(toNoneDecimal(decimal.number.toInt, 16))

  def hexadecimalToDecimal(hexadecimal: Number): Decimal =
    Decimal(toDecimal(hexadecimal.number, 16))

  def decimalToOctal(decimal: Number): Octal =
    Octal(toNoneDecimal(decimal.number.toInt, 8))

  def octalToDecimal(octal: Number): Decimal =
    Decimal(toDecimal(octal.number, 8))

  def binaryToDecimal(binary: Number): Decimal =
    Decimal(toDecimal(binary.number, 2))

  def decimalToBinary(decimal: Number): Binary =
    Binary(toBinary(BigInt(decimal.number), ""))

}
