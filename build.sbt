import Dependencies._
import TodoListPlugin._

ThisBuild / scalaVersion := "2.13.3"
ThisBuild / organization := "q2io"
ThisBuild / version := "0.0.1-SNAPSHOT"
ThisBuild / fork := true

scalacOptions ++= Seq("-language:_")

lazy val projectSettings = Seq(
  bloopAggregateSourceDependencies in Global := true,
  bloopExportJarClassifiers in Global := Some(Set("sources")),
  scalafmtOnCompile := true,
  resolvers ++= Seq(
    Resolver.sonatypeRepo("releases"),
    Resolver.sonatypeRepo("snapshots"),
    "jitpack" at "https://jitpack.io"
  ),
  addCompilerPlugin(
    "org.typelevel" %% "kind-projector" % "0.11.0" cross CrossVersion.full
  ),
  libraryDependencies ++= Seq(
    compilerPlugin(Dependencies.kindProject cross CrossVersion.full),
    compilerPlugin(Dependencies.betterMonadicFor)
  ),
  Test / fork := true,
  parallelExecution := false,
  Test / testForkedParallel := false
)

compileWithTodolistSettings

lazy val root = (project in file("."))
  .aggregate(c01, c02, c03, c04, c05, c06, c07, c08, c09, c10)
  .settings(
    publish / skip := true
  )
lazy val c01 = (project in file("chapter-01"))
  .settings(projectSettings: _*)

lazy val c02 =
  (project in file("chapter-02"))
    .settings(projectSettings: _*)
    .settings(libraryDependencies ++= Dependencies.coreDependencies)
    .enablePlugins(JavaAppPackaging)

lazy val c03 =
  (project in file("chapter-03"))
    .settings(projectSettings: _*)
    .settings(
      libraryDependencies ++= Dependencies.coreDependencies
    )
    .enablePlugins(JavaAppPackaging)

lazy val c04 = (project in file("chapter-04"))
  .settings(projectSettings: _*)
  .settings(
    libraryDependencies ++= Dependencies.coreDependencies
  )
  .enablePlugins(JavaAppPackaging)

lazy val c05 = (project in file("chapter-05"))
  .settings(projectSettings: _*)
  .settings(
    libraryDependencies ++= Dependencies.coreDependencies
  )
  .enablePlugins(JavaAppPackaging)

lazy val c06 = (project in file("chapter-06"))
  .settings(projectSettings: _*)
  .settings(
    libraryDependencies ++= Dependencies.coreDependencies
  )
  .enablePlugins(JavaAppPackaging)

lazy val c07 = (project in file("chapter-07"))
  .settings(projectSettings: _*)
  .settings(
    libraryDependencies ++= Dependencies.coreDependencies
  )
  .enablePlugins(JavaAppPackaging)

lazy val c08 = (project in file("chapter-08"))
  .settings(projectSettings: _*)
  .settings(
    libraryDependencies ++= Dependencies.coreDependencies
  )

lazy val c09 = (project in file("chapter-09"))
  .settings(projectSettings: _*)
  .settings(
    libraryDependencies ++= Dependencies.coreDependencies
  )
  .enablePlugins(JavaAppPackaging)

lazy val c10 = (project in file("chapter-10"))
  .settings(projectSettings: _*)
  .settings(
    libraryDependencies ++= Dependencies.coreDependencies
  )
