package me.scalawithcats.typeclasses

import cats.{ Eq => CatsEq }

import cats.instances.option._
import cats.syntax.option._

import me.scalawithcats.typeclasses.CatEq._

import org.scalatest.FunSuite

class CatEqTest extends FunSuite {
  val cat1 = Cat("Garfield", 38, "Orange and black")
  val cat2 = Cat("Heathcliff", 33, "Orange and black")

  val optCat1 = Option(cat1)
  val optCat2 = Option(cat2)
  
  assert(!(cat1 === cat2))
  
  assert(!(optCat1 === optCat2))
}
