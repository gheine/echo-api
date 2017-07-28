organization := "com.hbccommon"
name := "echo"
version := "0.1"
scalaVersion := "2.12.2"

val Http4sVersion = "0.15.11a"

enablePlugins(JavaAppPackaging)


libraryDependencies ++= Seq(
 "org.http4s"     %% "http4s-blaze-server" % Http4sVersion,
 "org.http4s"     %% "http4s-circe"        % Http4sVersion,
 "org.http4s"     %% "http4s-dsl"          % Http4sVersion,
 "ch.qos.logback" %  "logback-classic"     % "1.2.1"
)
