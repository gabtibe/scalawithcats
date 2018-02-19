import cats.Id
import cats.data.{Writer, WriterT}
import cats.instances.vector._
import cats.syntax.applicative._
import cats.syntax.writer._

val writer = Writer(Vector("Yes", "No"), 18)

type Writer[W, A] = WriterT[Id, W, A]

type Logged[A] = Writer[Vector[String], A]

123.pure[Logged]

Vector("msg1", "msg2").tell

val bWriter = Writer(Vector("a", "b"), 123)

val cWriter = 123.writer(Vector("a", "b"))

bWriter.value
bWriter.written
bWriter.run

