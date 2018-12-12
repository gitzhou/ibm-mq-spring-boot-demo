ibm-mq-spring-boot-demo
----

Refer to [ibm-messaging/mq-jms-spring](https://github.com/ibm-messaging/mq-jms-spring)

# How to run

Start an IBM MQ instance with Docker on your laptop

```
$ docker run --env LICENSE=accept --env MQ_QMGR_NAME=QM1 \
             --publish 1414:1414 \
             --publish 9443:9443 \
             --detach \
             ibmcom/mq
```

The default attributes are

```
ibm.mq.queueManager=QM1
ibm.mq.channel=DEV.ADMIN.SVRCONN
ibm.mq.connName=localhost(1414)
ibm.mq.user=admin
ibm.mq.password=passw0rd
```

Build project with Gradle

```
$ ./gradlew build
```

Run the jar file directly

```
$ java -jar build/libs/spring-ibm-mq-demo.jar


  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.0.RELEASE)

2018-12-13 13:59:10.470  INFO 74043 --- [           main] com.ibm.mq.spring.demo.Application       : Starting Application on bjzquan-mbp.cn.ibm.com with PID 74043 (/Users/bjzquan/idea-workspace/spring-ibm-mq-demo/out/production/classes started by bjzquan in /Users/bjzquan/idea-workspace/spring-ibm-mq-demo)
2018-12-13 13:59:10.473  INFO 74043 --- [           main] com.ibm.mq.spring.demo.Application       : No active profile set, falling back to default profiles: default
2018-12-13 13:59:11.368  INFO 74043 --- [           main] com.ibm.mq.spring.demo.Application       : Started Application in 1.158 seconds (JVM running for 1.662)
DEV.QUEUE.1 received ~Hello IBM MQ~
DEV.QUEUE.1 received ~q1 test~
DEV.QUEUE.2 received ~q2 test~
```

As you can see,

- The `main` method, sends message `Hello IBM MQ` to Queue `DEV.QUEUE.1`
- Class `Receiver` and `AnotherReceiver` consume messages
  - `Receiver` monitors Queue `DEV.QUEUE.1`
  - `AnotherReceiver` monitors Queue `DEV.QUEUE.2`

Do you own test with IBM MQ web console https://localhost:9443/ibmmq/console

Enjoy :smile:


