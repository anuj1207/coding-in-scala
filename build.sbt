import sbtsonar.SonarPlugin.autoImport.sonarProperties
name := "scala-refreshers"

version := "0.1"

scalaVersion := "2.12.10"

coverageExcludedPackages := "<empty>;" +
  "refreshers.scala.app.ProcessorHelper"

// https://mvnrepository.com/artifact/org.scalatest/scalatest
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.7" % Test

// https://mvnrepository.com/artifact/org.mockito/mockito-core
//libraryDependencies += "org.mockito" % "mockito-core" % "3.9.0" % Test

// https://mvnrepository.com/artifact/org.mockito/mockito-scala
libraryDependencies += "org.mockito" %% "mockito-scala" % "1.16.37" % Test

//libraryDependencies += "org.scalamock" %% "scalamock" % "5.1.0" % Test

sonarProperties ++= Map(
  "sonar.scala.version" -> scalaVersion.value,
  "sonar.projectName" -> name.value,
  "sonar.projectKey" -> "edu.scala-refreshers",
  "sonar.projectVersion" -> "sample-lable",
  "sonar.host.url" -> "http://localhost:9000/",
  "sonar.login" -> "admin",
  "sonar.password" -> "password",
  "sonar.coverage.exclusions" -> "src/main/scala/refreshers/scala/app/ProcessorHelper.scala,src/main/scala/refreshers/scala/app/ProcessHelper.scala",
//  "sonar.sources" -> "src/main/scala",
//  "sonar.tests" -> "src/test/scala",
  "sonar.scala.coverage.reportPaths" -> "target/scala-2.12/scoverage-report/scoverage.xml"
)
