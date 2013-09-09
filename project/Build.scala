import sbt._
import Keys._
import play.Project._
import com.typesafe.sbteclipse.core.EclipsePlugin.EclipseKeys

object ApplicationBuild extends Build {

  val appName         = "moduletest"
  val appVersion      = "1.0-SNAPSHOT"

  val testKey = SettingKey[String]("test-key", "Test Key!")

  override def settings = super.settings ++ Seq(EclipseKeys.skipParents in ThisBuild := false)
    
  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm,
    "com.typesafe" %% "play-plugins-mailer" % "2.1-RC2"
  )
  
  val modelLibrary = Project(appName + "-lib", file("model")).settings(scalaVersion := "2.10.0")

  val commonProject = play.Project(appName + "-common", appVersion, Nil, path = file("common")).dependsOn(modelLibrary)
  
  val adminProject = play.Project(appName + "-admin", appVersion, appDependencies, path = file("admin")).dependsOn(commonProject)
  val webProject = play.Project(appName + "-web", appVersion, Nil, path = file("web")).dependsOn(commonProject)

  // Root project must come first in alphabet!   
  val aaMain = play.Project(appName, appVersion, Nil, path = file("main")).settings(
    testKey := "Test"
    // Add your own project settings here
  ).dependsOn(adminProject, webProject).aggregate(adminProject, webProject) 

}
