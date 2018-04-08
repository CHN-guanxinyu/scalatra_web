name := "scalatra_web"

version := "1.0"

scalaVersion := "2.12.2"

val ScalatraVersion = "2.6.3"
val ServerPort = 8082
resolvers += Classpaths.typesafeReleases

libraryDependencies ++= Seq(
  "org.mortbay.jetty" % "jetty-rewrite-handler" % "6.1.10",
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "9.4.8.v20171121" % "container",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"
)
javaOptions ++= Seq(
  "-Xdebug",
  "-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"
)

import com.earldouglas.xwp.JettyPlugin.autoImport._
import com.earldouglas.xwp.ContainerPlugin.autoImport._
containerPort in Jetty := ServerPort
enablePlugins(SbtTwirl)
enablePlugins(ScalatraPlugin)
