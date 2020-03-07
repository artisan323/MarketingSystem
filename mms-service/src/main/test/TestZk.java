import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * 测试zookeeper连接
 */
public class TestZk {

    /**
     * 创建zookeeper连接
     * @return
     * @throws IOException
     */
    public static ZooKeeper startZK() throws IOException {
        return new ZooKeeper("101.200.32.76:2181", 20 * 1000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }

    /**
     * 关闭连接
     * @param zk
     * @throws InterruptedException
     */
    public static void stopZK(ZooKeeper zk) throws InterruptedException {
        if (zk != null){
            zk.close();
        }
    }

    /**
     * 创建ZNode节点
     * @param zk
     * @param nodePath
     * @param nodeValue
     * @throws KeeperException
     * @throws InterruptedException
     */
    public static void createZNode(ZooKeeper zk, String nodePath, String nodeValue) throws KeeperException, InterruptedException {
        zk.create(nodePath, nodeValue.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    /**
     * 获取ZNode节点的值
     * @param zk
     * @param nodePath
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public static String getZNode(ZooKeeper zk, String nodePath) throws KeeperException, InterruptedException {
        String result = null;
        byte[] bytes = zk.getData(nodePath, false, new Stat());
        result = new String(bytes);
        return result;
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zk = startZK();
        System.out.printf(zk.toString());

        if (zk.exists("/artisan", false) == null){
            createZNode(zk, "/artisan", "hello");
            String returnValue = getZNode(zk, "/artisan");
            System.out.printf(" returnValue =  " + returnValue);
        }else {
            System.out.printf("有此节点");
        }

        stopZK(zk);
    }
}
