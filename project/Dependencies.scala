import sbt._

object Version {
  val scalaTestVersion  = "3.2.15"

  val akkaVersion = "2.7.0"

  val slf4jVersion = "1.7.36"
  val logbackVersion = "1.2.11"
}

object Dependencies {
  import Version._

  lazy val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion

  lazy val akkaActorTyped = "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion

  lazy val logbackClassic = "ch.qos.logback" % "logback-classic" % logbackVersion excludeAll (
      ExclusionRule("org.slf4j")
    )
}
