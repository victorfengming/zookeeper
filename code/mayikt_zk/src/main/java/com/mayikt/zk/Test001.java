package com.mayikt.zk;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * ClassName: Test001 <br/>
 * Description: Test001 <br/>
 * Date: 2021-07-01 15:58 <br/>
 * <br/>
 *
 * @author yufengming
 * @version 产品版本信息 2021-07-01 15:58 yufengming(victorefengming.gitee.io) 新建<br/>
 * @project mayikt_zk
 * @package com.mayikt.zk
 * @email victorfengming@163.com
 * <p>
 * 修改记录
 */
public class Test001 {
    //         * 参数1. 链接地址

    private static final String ADDRES = "116.62.194.162:2181";
    //         * 参数2. zk超时事件
    private static final int TIMEOUT = 5000;

    //         * 参数3. 事件通知
//

    // countDownLatch计数器
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        // zk 核心节点 + 事件通知
        // 节点路径 和节点 value
        /**
         * 参数1. 链接地址
         * 参数2. zk超时事件
         * 参数3. 事件通知
         */

        // 1. 创建 zk链接
        ZooKeeper zooKeeper = new ZooKeeper(ADDRES, TIMEOUT, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                Event.KeeperState state = watchedEvent.getState();
                if (state == Event.KeeperState.SyncConnected) {
                    System.out.println("zk链接成功!!!");
                    // 计数器减一
                    countDownLatch.countDown();
                }
            }
        });

        System.out.println("zk 正在链接等待...");
        // 计数器 结果必须为0 才能继续执行
        countDownLatch.await();
        System.out.println("开始创建节点");
        // 2. 创建我门的节点
        // 参数1 路径名称
        // 参数2 节点value
        // 参数3. 节点权限 acl        OPEN_ACL_UNSAFE 开放权限
        // 参数4 节点类型 临时和永久
//        String s = zooKeeper.create("/mayikt2", "mayikt2_content".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        String s = zooKeeper.create("/mayikt3", "mayikt3_content".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
//        String s = zooKeeper.create("/mayikt", "content".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        String s = zooKeeper.create("/victor/s1", "content1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
        System.out.println(s);


        Thread.sleep(5000);

        /**
         * zk 节点分为4种类型
         * 1. 临时节点 - 会话关闭就没了 EPHEMERAL
         * 2. 持久节点 - 存到硬盘中,它不没 PERSISTENT
         * 3. 临时有序号节点 EPHEMERAL_SEQUENTIAL
         * 4. 持久有序号节点 CreateMode.PERSISTENT_SEQUENTIAL
         *
         */

    }
}
