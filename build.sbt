name := "assignment"

version := "1.0"

scalaVersion := "2.12.2"

resolvers ++= Seq("Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  Resolver.bintrayRepo("hseeberger", "maven"))

libraryDependencies ++= Seq(
  "org.scalatest"     %% "scalatest" % "3.0.1",
  "com.typesafe.play" %  "play-json_2.13.0-M1" % "2.6.6",
  "com.typesafe.akka" %% "akka-http"  % "10.0.6",
  "org.json4s"        %% "json4s-ext" % "3.5.2",
  "org.json4s"        %% "json4s-native"    % "3.5.2",
  "com.typesafe.akka" %% "akka-slf4j"       % "2.4.18",
  "de.heikoseeberger" %% "akka-http-json4s" % "1.16.0"
)



