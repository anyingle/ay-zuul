# ay-zuul

#### 问题攻关

###### case
+ 服务重启时或下线时抛出Forwarding error
  + 8081 spring-retry
  + 8082 重写源码, 重新获取已注册服务信息, 形成retry负载均衡

###### case
+ 同一个Eureka 注册两个不同ip段 it-ip
  + 如何让Zuul路由时优先选择最近IP段
