package com.mayikt.zk;

import org.apache.zookeeper.*;

import java.io.IOException;

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
//             * 参数1. 链接地址

    private static final String ADDRES = "116.62.194.162:2181";
//         * 参数2. zk超时事件
        private static final int TIMEOUT = 5000;

//         * 参数3. 事件通知
//
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
                    System.out.println("链接成功!!!");
                }
            }
        });

        // 创建我门的节点
        // 参数1 路径名称
        // 参数2 节点value
        // 参数3. 节点权限 acl        OPEN_ACL_UNSAFE 开放权限
        // 参数4 节点类型 临时和永久
        String s = zooKeeper.create("/mayikt", "mayikt".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(s);

        //

    }
}
