lazy val commonSettings = Seq(
  version := "1.0.0",
  scalaVersion := "2.11.7"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "stream"
)

// System dependencies
libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.0"
)

// Logging
libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.1.7",
  "com.trueaccord.scalapb" %% "scalapb-runtime-grpc" % "0.5.43",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0"
)

// gRPC
libraryDependencies ++= Seq(
  "io.grpc" % "grpc-netty" % "1.0.1",
  "com.trueaccord.scalapb" %% "scalapb-runtime-grpc" % "0.5.43",
  "io.netty" % "netty-tcnative-boringssl-static" % "1.1.33.Fork23"
)

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)

