package me.scalawithcats.monoids

trait Semigroup[A] {
  def |+|(x: A, y: A): A
}

trait Monoid[A] extends Semigroup[A] {
  def empty: A
}

object Monoid {
  def apply[A](implicit monoid: Monoid[A]): Monoid[A] = monoid

  implicit val booleanAndMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    def |+|(a1: Boolean, a2: Boolean): Boolean = a1 && a2
    override def empty: Boolean = true
  }

  implicit val booleanOrMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    def |+|(a1: Boolean, a2: Boolean): Boolean = a1 || a2
    override def empty: Boolean = false
  }

  implicit val booleanEitherMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    def |+|(a1: Boolean, a2: Boolean): Boolean = a1 && !a2 || !a1 && a2
    override def empty: Boolean = false
  }

  implicit val booleanXnorMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    def |+|(a1: Boolean, a2: Boolean): Boolean = (!a1 || a2) && (a1 || !a2)
    override def empty: Boolean = true
  }

  implicit def setUnionMonoid[A]: Monoid[Set[A]] = new Monoid[Set[A]] {
    def |+|(a1: Set[A], a2: Set[A]): Set[A] = a1 union a2
    override def empty: Set[A] = Set.empty[A]
  }
}

object testMonoid {
  implicit val intMonoid: Monoid[Int] = new Monoid[Int] {
    def |+|(a1: Int, a2: Int): Int = a1 + a2
    override def empty: Int = 0
  }

  implicit def setIntersectionSemiGroup[A] = new Semigroup[Set[A]] {
    def |+|(x: Set[A], y: Set[A]): Set[A] = x intersect y
  }
}
