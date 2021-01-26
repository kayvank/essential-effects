import sbt._

object Dependencies {
  object V {
    val logback = "1.2.3"
    val shapeless = "2.4.0-M1"
    val fs2 = "2.4.1"
    val monocle = "2.1.0"
    val spire = "0.17.0"
    val monix = "3.3.0"
    val iteratee = "0.19.0"
    val ammonite = "2.1.4"
    val scalacheckShapeless = "1.2.3"
    val spec2 = "4.9.4"
    val circe = "0.13"
    val http4s = "1.0-107-6676c1e"
    val cats = "2.3.1"
    val betterMonadicFor = "0.3.1"
    val kindProjector = "0.11.0"
  }

  val fs2Libs = Seq(
    "co.fs2" %% "fs2-core" % V.fs2,
    "co.fs2" %% "fs2-io" % V.fs2
  )
  val testLibs = Seq(
    "com.github.alexarchambault" %% "scalacheck-shapeless_1.14" % V.scalacheckShapeless % "test",
    "com.lihaoyi" %% "ammonite-ops" % V.ammonite % "test",
    "org.specs2" %% "specs2-core" % V.spec2 % "test",
    "org.specs2" %% "specs2-scalacheck" % V.spec2 % "test"
  )
  val circeLibs = Seq(
    "io.circe" %% "circe-core" % V.circe,
    "io.circe" %% "circe-generic" % V.circe,
    "io.circe" %% "circe-parser" % V.circe,
    "io.circe" %% "circe-optics" % V.circe
  )
  val http4sLibs = Seq(
    "org.http4s" %% "http4s-dsl" % V.http4s,
    "org.http4s" %% "http4s-blaze-server" % V.http4s,
    "org.http4s" %% "http4s-circe" % V.http4s
  )
  val catsLibs = Seq(
    "org.typelevel" %% "cats-effect" % V.cats,
    "org.typelevel" %% "cats-core" % V.cats,
    "org.typelevel" %% "cats-free" % V.cats
  )
  val logLibs =
    "ch.qos.logback" % "logback-classic" % V.logback

  val monocleLibs = Seq(
    "com.github.julien-truffaut" %% "monocle-core" % V.monocle,
    "com.github.julien-truffaut" %% "monocle-macro" % V.monocle
  )
  val monixLibs = "io.monix" %% "monix" % V.monix
  val shapelessLibs =
    "com.chuusai" %% "shapeless" % V.shapeless
  val spireLibs = "org.typelevel" %% "spire" % V.spire
  val iterateeLibs = "io.iteratee" %% "iteratee-core" % V.iteratee

  val coreDependencies = catsLibs ++ Seq(logLibs) ++ testLibs

  val betterMonadicFor =
    "com.olegpy" %% "better-monadic-for" % V.betterMonadicFor
  val kindProject = "org.typelevel" % "kind-projector" % V.kindProjector
}
