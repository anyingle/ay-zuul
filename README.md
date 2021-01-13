# ay-zuul

#### 问题攻关

###### case
+ 服务重启时或下线时抛出Forwarding error
  + 8081 spring-retry + Ribbon负载配置, 完美retry
  + 8082 重写源码, 重新获取已注册服务信息, 人工retry

###### case
+ 同一个Eureka
  + 注册两个不同ip段的zuul 和 it-service
  + Zuul优先访问相同ip段的实例, 且有容灾效果
  + 将eligible分为两个梯队, 根据ip选择有限梯队轮询, 
    如果优先梯队内没有数据则addAll备用梯队