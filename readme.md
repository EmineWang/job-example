# 直接启动ServerApplication  即可执行
 测试步骤：
 ***先打jar包

1 、先单机执行，设此服务器 A，观察日志的输出情况。

2、然后另外找一台服务器（会ip校验，不要另开ide执行）启动jar包,设此服务器 B ，（同时第1步中的服务A不要停止）

     分别观察两个机器的，日志情况。（此时应该是两个服务器各执行部分数据）

3： 停止第1步中的服务（模拟宕机），观察第2个服务器中的日志情况。（此时第1步中的服务器任务停止，所有任务都会有第2个机器执行）

4: 再次启动第1个服务器，数据再次被分布执行。

****根据上面执行结果，对照看下elastic-job分片策略。
配置参考文档：http://elasticjob.io/docs/elastic-job-lite/02-guide/config-manual/
参考文章：https://blog.csdn.net/peerless_hero/article/details/76686974?locationNum=10&fps=1
          https://blog.csdn.net/fanfan_v5/article/details/61310045
          https://www.cnblogs.com/haoxinyue/p/6919375.html



