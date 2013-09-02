package controllers

import play.api.mvc._

trait BaseController { self: Controller =>

  def htmlAnswer(html: String) = Results.Ok(html).as("text/html")
  
  def foo: String = "test2"
  
  def foo2 = "Hallo1"
    
}