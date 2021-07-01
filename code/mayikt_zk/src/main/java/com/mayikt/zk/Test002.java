package com.mayikt.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
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
public class Test002 {
    //         * 参数1. 链接地址

    private static final String ADDRES = "116.62.194.162:2181";
    //         * 参数2. zk超时事件
    private static final int TIMEOUT = 5000;

    //         * 参数3. 事件通知

    // countDownLatch计数器
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException, NoSuchAlgorithmException {
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

        // 1.2 .创建账号权限 admin可以实现读写操作
        Id id1 = new Id("digest", DigestAuthenticationProvider.generateDigest("admin:admin123"));
        ACL acl1 = new ACL(ZooDefs.Perms.ALL, id1);

// 3.创建权限guest 只允许做读操作
        Id id2 = new Id("digest", DigestAuthenticationProvider.generateDigest("guest:guest123"));
        ACL acl2 = new ACL(ZooDefs.Perms.READ, id2);


        // 4.添加该账号
        ArrayList<ACL> aces = new ArrayList<ACL>();
        aces.add(acl1);
        aces.add(acl2);


        // 2. 创建我门的节点
        // 参数1 路径名称
        // 参数2 节点value
        // 参数3. 节点权限 acl        OPEN_ACL_UNSAFE 开放权限
        // 参数4 节点类型 临时和永久

        String s = zooKeeper.create("/meite", "content".getBytes(), aces, CreateMode.PERSISTENT);
        System.out.println(s);

        // 09.Zookeeper节点ACL权限控制.mp4 4.53
    }
}
