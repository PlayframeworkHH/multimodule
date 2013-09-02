package controllers

import play.api._
import play.api.mvc._

object Application extends Controller with BaseController {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready. Yes."))
  }
  
  def hey = Action {
    htmlAnswer("Hey!")
  }
  
}