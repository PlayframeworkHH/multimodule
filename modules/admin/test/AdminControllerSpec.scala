package test

import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._
import java.io.File

class AdminControllerSpec extends Specification {
  
  val path = new File("./modules/admin")
  
  "AdminController" should {
    
    "render the index page" in {
      running(FakeApplication()) {
        val home = route(FakeRequest(GET, "/")).get
        
        status(home) must equalTo(OK)
        contentType(home) must beSome.which(_ == "text/html")
        contentAsString(home) must contain ("Admin Home")
      }
    }
  }
  
}