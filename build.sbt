import org.scalajs.sbtplugin.ScalaJSPlugin._
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

enablePlugins(ScalaJSPlugin)

val scalajsOutputDir = Def.settingKey[File]("directory for javascript files output by scalajs")

lazy val js2jvmSettings = Seq(fastOptJS, fullOptJS, packageJSDependencies) map { packageJSKey =>
  crossTarget in(Compile, packageJSKey) := scalajsOutputDir.value
}

lazy val p1 = project.in(file(".")).settings(js2jvmSettings: _*).settings(
  scalaVersion := "2.11.7",
  name := "Scala.js Tutorial",
  scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature"),
  ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) },
  scalaJSStage in Global := FastOptStage,
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.8.0",
    "be.doeraene" %%% "scalajs-jquery" % "0.8.0"
  ),
  scalajsOutputDir := file("./js") / "web"
)
