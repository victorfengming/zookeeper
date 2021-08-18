

# 01.Zookeeper集群可能会存在的问题.mp4

 

zk 集群中存在的一些问题

1. 每个节点数据一致性同步问题
2. zk如何解决分布式一致性问题 ZAB协议底层两阶段提交协议
3. 后期扩展新增 zk 节点需要注意的问题

![1625448865937](README/1625448865937.png)

# 02.Zk集群使用Observer实现扩展.mp4

首先在Zookeeper 中分为三种角色:。
1. Leader(领导)Zookeeper集群中的主节点、负责写的请求操作;。
2. Follower(跟随者）是领导(Leader)角色根随着，出读取操作还可以实现对Leader提议与选举
3. 0bserver如果后期当我们在扩展ZK集群节点时如果角色为Follower越来越多会导致
选举的时间越来越长，所以Observer角色和Follower角色很相似，只是obServer不能够参与Leader角色选举;
增加obServer_的作用主要不影响原来本身选举的时间效率、目的是提高客户端读的请求效率;

![1625449049441](README/1625449049441.png)

原来本身只有3台节点

1个leader

2个follower 剩余来台Follower从新选举

后期新增了2台Follower,总共变成了五台节点 剩余4台Follower从新选举

如果我们后期 zk节点 做扩容的时候 ,如果有节点 的类型 为Follower 类型,可能会导致选举时间越来越长

有可能会造成 整个zk环境不可使用;

注意事项: zk集群在后期扩容的时候,建议不要使用Follower节点类型,因为可能会导致选举 变长:

 zk 中分为 3种节点:

1. Leader类型 领导类型 负责写的请求,和各个节点同步;

2. Follower类型 跟随者

   中心化: 去中心化

   

02zk是哟概念Ob...扩展 11:21



# 03.如何在Zk集群配置ObServer.mp4



# 04.Zookeeper客户端连接集群地址.mp4



# 05.ZAB原子广播协议两种模型.mp4



# 06.Zookeeper集群解决数据一致性原理.mp4



# 07.Zookeeper集群策略zxid的作用.mp4



# 08.分布式情况下网络抖动脑裂概念.mp4



# 09.分布式架构中CAP与Base理论.mp4



# 10.Eureka与Zk作为注册中心区别.mp4



11.Zookeeper集群课后疑问.mp4





# 敏捷开发



拆分大功能

开会,立会

写代码,跑测试用例,提交,CI/CD,CodeReview,代码评审





