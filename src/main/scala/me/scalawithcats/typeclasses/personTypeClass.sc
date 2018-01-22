import me.scalawithcats.typeclasses._
import me.scalawithcats.typeclasses.JsonWriterHelper
import me.scalawithcats.typeclasses.JsonWriterInstanceTest._
import me.scalawithcats.typeclasses.JsonSyntax._
import me.scalawithcats.typeclasses.OptionWriter._

import me.scalawithcats.typeclasses.Cat
import me.scalawithcats.typeclasses.CatShow._
import me.scalawithcats.typeclasses.PrintableSyntax._

import cats.Show
import cats.instances.int._
import cats.instances.string._
import cats.instances.list._
import cats.instances.option._
import cats.instances.all._

//Json.toJson(Person("Gabriele", "gabriele.me"))

//Person("Gabriele", "gabriele.me").toJson
//
//val personImplicit = implicitly[JsonWriter[Person]]
//
//personImplicit.write(Person("Manuela", "manuela.me"))
//
//val optionMe =
//  Option(Person("Gabriele", "gabriele.me"))
//
//optionMe.toJson
//
//println(Cat("Garfield", 28, "Brown").show)

//val showInt: Show[Int] = Show.apply[Int]
//val showString: Show[String] = Show.apply[String]
//
//showInt.show(124)
//showString.show("Hello World!")