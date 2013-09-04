package controllers.web

import play.api.mvc._
import controllers.common.BaseController

object WebController extends Controller with BaseController {

  def index = Action {
    htmlAnswer("Web Index 1!")
  }
  
}