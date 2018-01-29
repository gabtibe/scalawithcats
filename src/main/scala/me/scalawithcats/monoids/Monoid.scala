//package me.scalawithcats.monoids
//
//trait FirstMonoid[A] {
//  def compose(a1: A, a2: A): A
//  def |+|(a1: A, a2: A): A = this.compose(a1, a2)
//  def empty: A
//}
//
//object Monoid {
//  def associativeLaw[A](x: A, y: A, z: A)(implicit m: FirstMonoid[A]): Boolean =
//    (x |+| (y |+| z)) == ((x |+| y) |+| z)
//
//  def identityLaw[A](x: A)(implicit m: FirstMonoid[A]) =
//   ((x |+| m.empty) == x) && ((m.empty |+| x) == x)
//}
