import AssemblyKeys._

assemblySettings

name := "PredictionIO-Process-ItemRec-Evaluations-TopKItems"

version := "0.7.0-SNAPSHOT"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
  "io.prediction" %% "predictionio-commons" % "0.7.0-SNAPSHOT",
  "io.prediction" %% "predictionio-output" % "0.7.0-SNAPSHOT",
  "ch.qos.logback" % "logback-classic" % "1.0.9",
  "ch.qos.logback" % "logback-core" % "1.0.9",
  "com.github.scala-incubator.io" %% "scala-io-core" % "0.4.2",
  "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.2",
  "com.typesafe" % "config" % "1.0.0",
  "org.clapper" %% "grizzled-slf4j" % "1.0.1"
)

resolvers ++= Seq(
  "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"
)

excludedJars in assembly <<= (fullClasspath in assembly) map { cp =>
  val excludes = Set("minlog-1.2.jar")
  cp filter { jar => excludes(jar.data.getName)}
}
