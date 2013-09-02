package controllers

import play.api._
import play.api.mvc._

object AdminController extends Controller with BaseController {

  def index = Action { req =>
    htmlAnswer("Admin Home Page")
  }
  
  def hey = Action {
    htmlAnswer("Admin Hey, Yes!")
  }
  
}