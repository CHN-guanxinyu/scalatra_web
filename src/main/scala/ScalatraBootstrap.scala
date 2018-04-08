
import java.io.File
import javax.servlet.ServletContext

import com.github.Lcafebabe.scalatra.MainServlet
import org.scalatra._

import scala.xml.{Elem, XML}

class ScalatraBootstrap extends LifeCycle {
  override def destroy(context: ServletContext): Unit = {

  }



  override def init(context: ServletContext) {
    implicit val _ctx = context

    //Mount servlets
    mountServlets

    //DB Config
    initDatasource




  }

  def resourceFile(confFile : String)(implicit context : ServletContext) : Elem ={
    XML.load(context.getResource("/conf/"+confFile))
  }


  def mountServlets(implicit context : ServletContext): Unit ={
    val servlets = resourceFile("servlets.xml") \ "servlet"

    servlets foreach { servlet=>
      val Array( pattern , mapping ) =
        Array("pattern","mapping").map( servlet \ ).map(_.head.text)

      context.mount( Class.forName(mapping).newInstance().asInstanceOf[Handler] , pattern )
    }
  }

  def initDatasource: Unit = {}
}
