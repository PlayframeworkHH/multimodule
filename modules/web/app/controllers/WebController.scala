package controllers

import play.api.mvc._

object WebController extends Controller with BaseController {

  def index = Action {
    htmlAnswer("Web Index 1!")
  }
  
}