package zookeeper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhangcx
 * @date 2020-8-30 13:28
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZkConsumerOrderMain {
    public static void main(String[] args) {
        SpringApplication.run(ZkConsumerOrderMain.class,args);
    }
}
