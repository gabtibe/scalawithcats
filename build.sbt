name := "scalawithcats"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "1.0.0",
  "org.scalatest" %% "scalatest" % "3.2.0-SNAP9" % Test
)

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-Ypartial-unification"
)