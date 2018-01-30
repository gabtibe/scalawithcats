package me.scalawithcats.typeclasses

trait Printable[A] { self =>
  def format(value: A): String
  def contramap[B](f: B => A): Printable[B] =
    new Printable[B] {
      override def format(value: B): String = self.format(f(value))
    }
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
