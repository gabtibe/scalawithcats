package me.scalawithcats.exercises.chapter2

import cats.Monoid
import cats.syntax.monoid._
import cats.instances.int._
import cats.instances.option._

object SuperAdder {
  def add[A](items: List[A])(implicit m: Monoid[A]): A = items.foldLeft(m.empty)(_ |+| _)

  implicit val orderMonoid: Monoid[Order] = new Monoid[Order]{
    override def empty: Order = Order(0, 0)
    override def combine(x: Order, y: Order): Order =
      Order(x.totalCost + y.totalCost, x.quantity + y.quantity)
  }
}

case class Order(totalCost: Double, quantity: Double)


