package controllers.admin

import play.api._
import play.api.mvc._
import controllers.common.BaseController

object AdminController extends Controller with BaseController {

  def index = Action { implicit req =>
    htmlAnswer("Admin Home Page<br><a href=\"" + routes.AdminController.hey.absoluteURL(false) + "\">Hey</a>")
  }
  
  def hey = Action {
    htmlAnswer("Admin Hey, Yes!")
  }
  
}