package com.hernanjw.grpc.helloworld

import java.util.concurrent.TimeUnit
import java.util.logging.{Level, Logger}

import io.grpc.examples.helloworld.helloworld.GreeterGrpc.GreeterBlockingStub
import io.grpc.examples.helloworld.helloworld.{GreeterGrpc, HelloReply, HelloRequest}
import io.grpc.{ManagedChannel, ManagedChannelBuilder, StatusRuntimeException}

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

object HelloWorldClient {

  def main(args: Array[String]): Unit = {
    implicit val context = scala.concurrent.ExecutionContext.Implicits.global
    val logger = Logger.getLogger(HelloWorldClient.toString)

    val port = 50051
    val channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext(true).build
    val blockingStub = GreeterGrpc.blockingStub(channel)

    val name = "world"
    logger.info("Will try to greet " + name + " ...")
    val request = HelloRequest(name)
    try {
      val response = blockingStub.sayHello(request)
      logger.info("Greeting: " + response.message)
    }
    catch {
      case e: StatusRuntimeException => logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus)
    }
    finally {
      channel.shutdown.awaitTermination(5, TimeUnit.SECONDS)
    }
  }
}