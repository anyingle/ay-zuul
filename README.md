# ay-zuul

#### 问题攻关
+ 启动Eureka
+ 启动Service1
+ 启动Zuul
+ 网页访问localhost:8081/it-service/index
  + 弹出ip视为正常
+ 重启Service1
  + 此时持续刷新页面，直到无法访问
  + Zuul会报错 forwarding  error
  + 增加retry解决单服务问题
+ 先把82 83上去，再把 81 82下去，看下有没有问题
  + 需要解决 81服务死掉 ribbon 如何自动将请求retry到83上
