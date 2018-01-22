package me.scalawithcats.typeclasses

import java.util.Date
import cats.Show
import cats.instances.all._

object CustomShow {
  implicit val dateShow: Show[Date] = new Show[Date] {
    override def show(t: Date): String = s"${t.getTime}ms since the epoch"
  }

  implicit val dateShow2: Show[Date] =
    Show.show(date => s"${date.getTime}ms since the epoch")
}

