import cats.data.State

val a = State[Int, String] { state =>
  (state, s"The state is $state")
}

a.run(10).value
a.runS(10).value
a.runA(10).value

val step1 = State[Int, String] { state =>
  val ans = state + 1
  (ans, s"Result of step 1 is $ans")
}

val step2 = State[Int, String] { num =>
  val ans = num * 2
  (ans, s"Result of step 2 is $ans")
}

val both =
  for {
    s1 <- step1
    s2 <- step2
  } yield (s1, s2)

val (state, result) = both.run(20).value

