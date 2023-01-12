package com.pigumer
import akka.stream.Materializer

import scala.concurrent.Future

class HelloServiceImpl(implicit mat: Materializer) extends HelloService {

  override def hello(in: HelloRequest): Future[HelloResult] =
    Future.successful(HelloResult(s"Hello ${ in.name }"))
}
