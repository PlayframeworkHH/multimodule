import sbt._
import Keys._
import play.Project._
import com.typesafe.sbteclipse.core.EclipsePlugin.EclipseKeys

object ApplicationBuild extends Build {

  val appName         = "moduletest"
  val appVersion      = "1.0-SNAPSHOT"

  override def settings = super.settings ++ Seq(EclipseKeys.skipParents in ThisBuild := false)
    
  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm
  )
  
  val modelLibrary = Project(appName + "-lib", file("modules/model")).settings(scalaVersion := "2.10.0")

  val commonProject = play.Project(appName + "-common", appVersion, appDependencies, path = file("modules/common")).dependsOn(modelLibrary)
  
  val adminProject = play.Project(appName + "-admin", appVersion, appDependencies, path = file("modules/admin")).dependsOn(commonProject)
  val webProject = play.Project(appName + "-web", appVersion, appDependencies, path = file("modules/web")).dependsOn(commonProject)

  // Root project must come first in alphabet!   
  val aaMain = play.Project(appName, appVersion, appDependencies, path = file("main")).settings(
    // Add your own project settings here
  ).dependsOn(adminProject, webProject).aggregate(adminProject, webProject) 

}
