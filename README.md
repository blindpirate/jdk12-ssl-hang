# Step to reproduce

### JDK 11.0.2

```
$ javac -cp jetty-6.1.26.jar:jetty-util-6.1.26.jar:servlet-api-2.5-20081211.jar *.java

$ java -cp jetty-6.1.26.jar:jetty-util-6.1.26.jar:servlet-api-2.5-20081211.jar:. Main
2019-04-03 16:59:20.510:INFO::Logging to STDERR via org.mortbay.log.StdErrLog
2019-04-03 16:59:20.510:INFO::jetty-6.1.26
2019-04-03 16:59:20.539:INFO::Started SocketConnector@0.0.0.0:8080
2019-04-03 16:59:20.658:INFO::Started SslSocketConnector@0.0.0.0:50800
2019-04-03 16:59:22.844:INFO::Stopped SslSocketConnector@0.0.0.0:50800
2019-04-03 16:59:22.847:INFO::Stopped SocketConnector@0.0.0.0:8080

```

### JDK 12 GA

```
$ /Library/Java/JavaVirtualMachines/jdk-12.jdk/Contents/Home/bin/java -cp jetty-6.1.26.jar:jetty-util-6.1.26.jar:servlet-api-2.5-20081211.jar:. Main
2019-04-03 16:59:46.702:INFO::Logging to STDERR via org.mortbay.log.StdErrLog
2019-04-03 16:59:46.702:INFO::jetty-6.1.26
2019-04-03 16:59:46.733:INFO::Started SocketConnector@0.0.0.0:8080
2019-04-03 16:59:46.854:INFO::Started SslSocketConnector@0.0.0.0:50825
2019-04-03 16:59:49.039:INFO::Stopped SslSocketConnector@0.0.0.0:50825
...hangs here for about 6 minutes
```

