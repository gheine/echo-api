organization := "com.hbccommon"
name := "echo"
version := "0.1"
scalaVersion := "2.12.3"

val http4sVersion = "0.15.16a"
val circeVersion = "0.8.0"

enablePlugins(JavaAppPackaging)

libraryDependencies ++= Seq(
 "org.http4s"           %% "http4s-core"               % http4sVersion,
 "org.http4s"           %% "http4s-dsl"                % http4sVersion,
 "org.http4s"           %% "http4s-blaze-server"       % http4sVersion,
 "org.http4s"           %% "http4s-circe"              % http4sVersion,
 "org.http4s"           %% "http4s-blaze-client"       % http4sVersion,
 "io.circe"             %% "circe-generic"             % circeVersion,
 "org.scalacheck"       %% "scalacheck"                % "1.13.5"   % "test",
 "org.scalatest"        %% "scalatest"                 % "3.0.3"    % "test",
 "ch.qos.logback" %  "logback-classic"     % "1.2.1"
)

