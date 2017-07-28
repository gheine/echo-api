organization := "com.hbccommon"
name := "echo"
version := "0.1"
scalaVersion := "2.12.2"

val Http4sVersion = "0.15.11a"



val http4sVersion = "0.15.13a"
val circeVersion = "0.8.0"
val doobieVersion = "0.4.1"
val awsSdkVersion = "1.11.145"


enablePlugins(JavaAppPackaging)


libraryDependencies ++= Seq(
 "org.http4s"           %% "http4s-core"               % http4sVersion,
 "org.http4s"           %% "http4s-dsl"                % http4sVersion,
 "org.http4s"           %% "http4s-blaze-server"       % http4sVersion,
 "org.http4s"           %% "http4s-circe"              % http4sVersion,
 "org.http4s"           %% "http4s-blaze-client"       % http4sVersion,
 "io.circe"             %% "circe-core"                % circeVersion,
 "io.circe"             %% "circe-generic"             % circeVersion,
 "io.circe"             %% "circe-generic-extras"      % circeVersion,
 "io.circe"             %% "circe-parser"              % circeVersion,
 "io.circe"             %% "circe-java8"               % circeVersion,
 "com.amazonaws"         % "aws-java-sdk-cloudwatch"   % awsSdkVersion,
 "com.amazonaws"         % "aws-java-sdk-s3"           % awsSdkVersion,
 "com.amazonaws"         % "aws-java-sdk-kms"          % awsSdkVersion,
 "ch.qos.logback" %  "logback-classic"     % "1.2.1"
)



