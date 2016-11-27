# stream-mobile
## Overview
Uses grpc to communicate between a scala server, and an android client.

- run `sbt compile` in the `streams/` directory to generate the scala gRPC classes as specified by the files in 
- run  `AndroidStreamClient/gradlew build` to generate the java gRPC classes.

## References
- [ScalaPb](https://scalapb.github.io/index.html) protocol buffer compiler for scala
- [gRpC-java Android examples](https://github.com/grpc/grpc-java/tree/master/examples)
