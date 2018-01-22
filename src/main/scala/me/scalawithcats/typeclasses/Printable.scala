package me.scalawithcats.typeclasses

trait Printable[A] {
  def format(value: A): String
}

object Printable {
  def format[A](value: A)(implicit printable: Printable[A]): String =
    printable.format(value)

  def print[A](value: A)(implicit printable: Printable[A]): Unit =
    println(format(value))
}

object PrintableInstances {
  implicit val stringPrintable: Printable[String] = new Printable[String] {
    override def format(value: String): String = value.toString
  }

  implicit val intPrintable: Printable[Int] = new Printable[Int] {
    override def format(value: Int): String = value.toString
  }
}

object PrintableSyntax {
  implicit class PrintableOps[A](printableValue: A) {
    def format(implicit printable: Printable[A]): String = printable.format(printableValue)
    def print(implicit printable: Printable[A]): Unit = println(printable.format(printableValue))
  }
}
