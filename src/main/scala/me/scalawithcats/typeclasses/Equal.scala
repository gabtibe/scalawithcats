package me.scalawithcats.typeclasses

import cats.{Eq => CatsEq}

trait Eq[A] {
  def eqv(a: A, b: A): Boolean
  def neqv(a: A, b: A): Boolean = !eqv(a, b)
}

object CatEq {
  implicit val catEqual: CatsEq[Cat] =
    CatsEq.instance[Cat] { (a: Cat, b: Cat) =>
      (a.age == b.age) &&
        (a.color == b.color) &&
        (a.name == b.name)
    }
}





