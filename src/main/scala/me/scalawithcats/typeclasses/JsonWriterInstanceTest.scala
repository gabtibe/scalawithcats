package me.scalawithcats.typeclasses

final case class Person(name: String, email: String)

object JsonWriterInstanceTest {
  implicit val stringWriter: JsonWriter[String] =
    new JsonWriter[String] {
      override def write(value: String): Json = JsString(value)
    }

  implicit val personWriter: JsonWriter[Person] =
    new JsonWriter[Person] {
      override def write(person: Person): Json =
        JsObject(
          Map(
          "Name" -> JsString(person.name),
          "Email" -> JsString(person.email)
          )
        )
    }
}

object JsonWriterHelper {
  def toJson[A](value: A)(implicit w: JsonWriter[A]): Json =
    w.write(value)
}

object JsonSyntax {
  implicit class JsonWriterOps[A](value: A) {
    def toJson(implicit w: JsonWriter[A]): Json =
      w.write(value)
  }
}