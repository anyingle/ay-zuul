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
