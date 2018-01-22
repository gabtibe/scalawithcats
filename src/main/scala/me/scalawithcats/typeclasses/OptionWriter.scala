package me.scalawithcats.typeclasses

object OptionWriter {
  implicit def optionWriter[A]
    (implicit writer: JsonWriter[A]): JsonWriter[Option[A]] =
    new JsonWriter[Option[A]] {
      override def write(option: Option[A]): Json =
        option match {
          case Some(aValue) => writer.write(aValue)
          case None => JsNull
        }
    }
}
