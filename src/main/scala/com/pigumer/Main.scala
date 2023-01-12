package com.pigumer

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorSystem, Behavior}
import akka.http.scaladsl.Http
import com.typesafe.config.ConfigFactory

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Server {
  def setup: Behavior[Any] = Behaviors.setup { ctx =>
    implicit val system = ctx.system

    val helloService = HelloServiceHandler.withServerReflection(new HelloServiceImpl())

    Http().
      newServerAt("127.0.0.1", -1).
      bind(helloService)

    Behaviors.same
  }
}

object Main extends App {
  val conf = ConfigFactory.load()
    .withFallback(ConfigFactory.defaultApplication())

  val system = ActorSystem(Server.setup, "hello", conf)
  Await.ready(system.whenTerminated, Duration.Inf)
}
