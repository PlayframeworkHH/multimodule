package controllers.admin

import play.api._
import play.api.mvc._
import play.api.Play.current
import controllers.common.BaseController

object AdminController extends Controller with BaseController {

  def index = Action { implicit req =>
    htmlAnswer("Admin Home Page<br><a href=\"" + routes.AdminController.hey.absoluteURL(false) + "\">Hey</a>")
  }
  
  def hey = Action {
    htmlAnswer("Admin Hey, Yes!")
  }
  
  def mailTest = Action {
    import com.typesafe.plugin._
    val mail = use[MailerPlugin].email
    mail.setSubject("Mail Test")
    mail.addRecipient("mgottschalk@gmx.net")
    mail.addFrom("mgottschalk@gmx.net")
    mail.send("Test Email.")
    
    htmlAnswer("Mail was sent!")
  }
  
}