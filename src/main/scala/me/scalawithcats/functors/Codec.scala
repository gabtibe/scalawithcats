package me.scalawithcats.functors

trait Codec[T] {
  def encode(x: T): String
  def decode(x: String): T
  def imap[W](dec: T => W, enc: W => T): Codec[W] = {
    val self = this
    new Codec[W] {
      override def encode(x: W): String = self.encode(enc(x))
      override def decode(x: String): W = dec(self.decode(x))
    }

  }
}

object Codec {
  def encode[T](value: T)(implicit c: Codec[T]): String =
    c.encode(value)
  def decode[T](value: String)(implicit c: Codec[T]): T =
    c.decode(value)
}
