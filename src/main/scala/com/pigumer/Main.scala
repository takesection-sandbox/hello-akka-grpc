package com.pigumer

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import com.typesafe.config.ConfigFactory

object Server {
  def apply(implicit system: ActorSystem) {
    val helloService = HelloServiceHandler.withServerReflection(new HelloServiceImpl())

    Http().
      newServerAt("127.0.0.1", -1).
      bind(helloService)
  }
}

object Main extends App {
  val conf = ConfigFactory
    .parseString("akka.http.server.preview.enable-http2 = on")
    .withFallback(ConfigFactory.defaultApplication())

  val system = ActorSystem("hello", conf)
  Server(system)
}
