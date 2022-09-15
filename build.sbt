ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "scala_tdd"
  )

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.12" % "test",
  "io.cucumber" %% "cucumber-scala" % "8.9.0" % "test",
  "io.cucumber" % "cucumber-junit" % "7.7.0" % "test",
  "junit" % "junit" % "4.13.2" % "test"
)
