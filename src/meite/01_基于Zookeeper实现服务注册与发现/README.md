# 01.基于Zookeeper实现动态负载均衡课程介绍.mp4


# 02.Zookeeper实际案例中的应用场景.mp4

zk - 分布式领域中的协调者

zk应用场景 ：

1. 分布式锁 （redis或者zk）
2. Dubbo服务注册（zk）
3. 分布式配置中心 disconfig（百度的一个框架， 它吧它的配置信息放到了zk上了）
4. 分布式消息中间件
5. 发布订阅（事件通知）
6. Master 选举（zk节点是唯一的）



zk之所以能够帮我们解决这些问题，是离不开zk的特性： 

Zookeeper的特性： 类似文件系统

/

/mayikt/

/mayitk/s0

---





·分布式Zookeeper快速入门
.什么是Zookeeper.
官方文档上这么解释zookeeper，它是一个分布式服务框架，是Apache Hadoop 的一个子项目，它主要是用来解决分布式应用中经常遇到的一些数据管理问题，如:统一命名服务、状态同步服务、集群管理、分布式应用配置项的管理等。+
上面的解释有点抽象，简单来说zookeeper=文件系统+监听通知机制。



---





# 03.Zookeeper基本的实现的特征.mp4



# 04.基于linux环境安装Zookeeper.mp4



# 05.注意安装Zookeeper前安装Jdk环境.mp4



# 06.Java语言客户端连接Zookeeper.mp4



# 07.Countdown计算器优化ZK代码.mp4



# 08.Zookeeper四种节点类型.mp4



# 09.Zookeeper节点ACL权限控制.mp4



# 10.使用Zookeeper实现服务注册.mp4



# 11.使用Zookeeper实现服务发现.mp4