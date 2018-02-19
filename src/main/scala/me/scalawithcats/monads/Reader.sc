import cats.data.Reader
import cats.syntax.applicative._

case class Cat(name: String, favFood: String)

val catName: Reader[Cat, String] =
  Reader(cat => cat.name)

catName.run(Cat("Garfield", "AAA"))

val greetKitty: Reader[Cat, String] =
  catName.map(name => s"Hello $name")

greetKitty.run(Cat("Kitty", "AAA"))

val feedKitty: Reader[Cat, String] =
  Reader(cat => s"Have some ${cat.favFood}!")

val feedAndGreetKitty =
  for {
    greet <- greetKitty
    feed <- feedKitty
  } yield s"$greet, $feed"

feedAndGreetKitty(Cat("Kitty", "Haribo"))

case class Db(usernames: Map[Int, String], passwords: Map[String, String])

type DbReader[A] = Reader[Db, A]

def findUser(userId: Int): DbReader[Option[String]] =
  Reader(db => db.usernames.get(userId))

def checkPassword(username: String, password: String): DbReader[Boolean] =
  Reader(db => db.passwords.get(username).contains(password))

def checkLogin(userId: Int, password: String) =
  for {
    user <- findUser(userId)
    passwordOk <- user.map { userName =>
      checkPassword(userName, password)
    }.getOrElse(false.pure[DbReader])
  } yield passwordOk

val users = Map(
  1 -> "dade",
  2 -> "kate",
  3 -> "margo"
)

val passwords = Map(
  "dade"  -> "zerocool",
  "kate"  -> "acidburn",
  "margo" -> "secret"
)

val db = Db(users, passwords)

checkLogin(1, "zerocool").run(db)
checkLogin(4, "davinci").run(db)
