# ay-zuul

#### 问题攻关

###### case
+ 服务重启时，下线又上线这个期间被访问
  + zuul 抛出forwarding error
  + 注册2个小集群
    + 新服务上线
      + 有延迟，并不能及时被zuul发现
    + 老服务下线
      + 服务关闭时依然在岗，接收到请求无法处理，会报错 
      + 如何保证其中一个下线时可以让请求自己retry到另一个服务上
  + 已知 zuul 源码 RibbonRoutingFilter
    + ClientHttpResponse response = forward(commandContext);
    + 只要重新获取commandContext即可实现load balance

###### case
+ 同一个Eureka 注册两个不同ip段 it-ip
  + 如何让Zuul路由时优先选择最近IP段
