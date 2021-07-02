package com.mayikt.zk;

import jdk.nashorn.internal.objects.annotations.Where;
import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;
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
public class Test006 {
    //参数1 连接地址
        private static final String ADDRES = "116.62.194.162:2181";

//    private static final String ADDRES = "192.168.212.147:2181";
    // 参数2 zk超时时间
    private static final int TIMEOUT = 5000;
    // 计数器
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {

        // 创建了一个父节点 /mayikt-service/8080|8081
        // 1.创建我们的zk连接
        ZkClient zkClient = new ZkClient(ADDRES, TIMEOUT);
        String parentPath = "/mayikt-service";
//        // 2.监听节点发生的变化 监听子节点是否有发生变化 如果发生变化都可以获取到回调通知
//        zkClient.subscribeChildChanges(parentPath, new IZkChildListener() {
//            @Override
//            public void handleChildChange(String s, List<String> list) throws Exception {
//                System.out.println("s:" + s + ",节点发生了变化");
//                list.forEach((t) -> System.out.println(t));
//            }
//        });
        // 2.监听节点的value值是否发生变化
        zkClient.subscribeDataChanges(parentPath + "/8080", new IZkDataListener() {
            @Override
            // 节点的内容是否发生变化
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println("s:" + s + ",o:" + o);
            }

            @Override
            // 监听该节点是否被删除
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("s被删除:" + s);
            }
        });
//
//        //修改值内容
//        zkClient.writeData(parentPath, "meite_mayikt");

        while (true) {

        }

//        zkClient.close();


    }
}
