
version := "0.1.0-SNAPSHOT"

scalaVersion := "2.13.13"

lazy val root = (project in file("."))
  .settings(
    name := "scala-spark",
    idePackagePrefix := Some("pl.jonasz")
  )
libraryDependencies += "org.apache.spark" %% "spark-core" % "3.5.1"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.5.1"
