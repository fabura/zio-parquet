val ZioVersion = "1.0-RC5"
val ParquetVersion = "1.10.1"
val HadoopVersion = "3.2.0"

resolvers += Resolver.sonatypeRepo("releases")
resolvers += Resolver.sonatypeRepo("snapshots")

lazy val root = (project in file("."))
  .settings(
    organization := "ZIO",
    name := "zio-parquet",
    version := "0.0.1",
    scalaVersion := "2.12.8",
    maxErrors := 3,
    libraryDependencies ++= Seq(
      "org.scalaz" %% "scalaz-zio" % ZioVersion, 

      "org.apache.parquet"  % "parquet-avro"   % ParquetVersion,
      "org.apache.hadoop"   % "hadoop-common"  % HadoopVersion,
    )
  )

scalacOptions := Seq(
  //"-Xsource:2.13",
  //"-Xlint",
  "-Xverify",
  "-feature",
  "-deprecation",
  "-explaintypes",
  "-unchecked",
  "-Xfuture",
  "-encoding",
  "UTF-8",
  "-Yrangepos",
  //"-Xlint:_,-type-parameter-shadow",
  //"-Ywarn-numeric-widen",
  //"-Ywarn-unused",
  //"-Ywarn-value-discard",
  "-language:higherKinds",
  "-language:existentials",
  "-Yno-adapted-args",
  "-Ypartial-unification",
  //"-Xfatal-warnings",
  //"-Xlint:-infer-any,_",
  //"-Ywarn-value-discard",
  //"-Ywarn-numeric-widen",
  //"-Ywarn-extra-implicit",
  //"-Ywarn-unused:_",
  //"-Ywarn-inaccessible",
  //"-Ywarn-nullary-override",
  //"-Ywarn-nullary-unit",
  "-opt-inline-from:<source>",
  //"-opt-warnings",
  "-opt:l:inline",
)

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)

addCommandAlias("fmt", "all scalafmtSbt scalafmt test:scalafmt")
addCommandAlias("chk", "all scalafmtSbtCheck scalafmtCheck test:scalafmtCheck")
