package me.scalawithcats.typeclasses

import cats.Show

final case class Cat(name: String, age: Int, color: String)

object Cat {
  implicit val printableCat: Printable[Cat] = new Printable[Cat] {
    override def format(cat: Cat): String =
      s"${cat.name} is a ${cat.age} year-old ${cat.color} cat"
  }
}

object CatShow {
  implicit val showableCat: Show[Cat] =
    Show.show(cat => s"${cat.name} is a ${cat.age} year-old ${cat.color} cat")
}
