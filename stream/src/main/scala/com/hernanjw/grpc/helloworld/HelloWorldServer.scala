package com.hernanjw.grpc.helloworld

import java.util.logging.Logger

import io.grpc.{Server, ServerBuilder}
import com.hernanjw.grpc.GreeterImpl
import io.grpc.examples.helloworld.helloworld.GreeterGrpc

import scala.concurrent.{ExecutionContext, Future}

object HelloWorldServer {
  def main(args: Array[String]): Unit = {
    val logger = Logger.getLogger(HelloWorldServer.toString)
    val executionContext = scala.concurrent.ExecutionContext.Implicits.global
    val port = 50051

    val server = ServerBuilder.forPort(port).addService(GreeterGrpc.bindService(GreeterImpl, executionContext)).build.start
    logger.info(s"Server started, listening on port $port")
    server.awaitTermination()
  }

}
