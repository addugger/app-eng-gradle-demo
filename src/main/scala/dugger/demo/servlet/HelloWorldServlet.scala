package dugger.demo.servlet

import org.scalatra.ScalatraServlet

class HelloWorldServlet extends ScalatraServlet {
  get("/") {
    <html>
      <body>
        <h1>Give it up!</h1>
        Say <a href="hello-scalate">hello to Scalate</a>.
      </body>
    </html>
  }
}
