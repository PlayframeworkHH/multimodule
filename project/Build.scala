import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "modules-test-play"
  val appVersion      = "1.0-SNAPSHOT"
    
  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm
  )
  
  val modelLibrary = Project("model-library", file("modules/model")).settings(scalaVersion := "2.10.0")

  val commonProject = play.Project(appName + "-common", appVersion, path = file("modules/common")).dependsOn(modelLibrary)
  
  val adminProject = play.Project(appName + "-admin", appVersion, path = file("modules/admin")).dependsOn(commonProject)
  val webProject = play.Project(appName + "-web", appVersion, path = file("modules/web")).dependsOn(commonProject)
  
  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  ).dependsOn(adminProject, webProject).aggregate(adminProject, webProject)

}
