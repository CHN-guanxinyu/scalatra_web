package com.github.Lcafebabe.scalatra

import org.scalatra.ScalatraServlet


class MainServlet extends ScalatraServlet {
  before() {
    contentType = "text/html"
  }

  get("/") {
    println(1)
  }
}