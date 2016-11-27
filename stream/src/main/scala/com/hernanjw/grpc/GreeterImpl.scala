package com.hernanjw.grpc

import io.grpc.examples.helloworld.helloworld.{GreeterGrpc, HelloReply, HelloRequest}

import scala.concurrent.Future

object GreeterImpl extends GreeterGrpc.Greeter {
  override def sayHello(request: HelloRequest): Future[HelloReply] = {
    Future.successful(HelloReply(s"Hello: ${request.name}"))
  }
}
