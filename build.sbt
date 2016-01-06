enablePlugins(ScalaJSPlugin)

scalaJSStage in Global := FastOptStage

name := "Scala.js Tutorial"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.8.0",
  "be.doeraene" %%% "scalajs-jquery" % "0.8.0"
)
