package dugger.demo.servlet

import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

class HelloWorldServlet extends HttpServlet {
  override def doGet(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    resp.setContentType("text/plain")
    resp.getWriter.print("What up world?!")
  }
}
