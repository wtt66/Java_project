package cn.itcast.order;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }


    /**
     * 创建RestTemplate并注入Spring容器
     * @return
     */
    @Bean
    @LoadBalanced //负载均衡注解
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    /*
    * 修改负载均衡策略*/
    /*@Bean
    public IRule randomRule(){
        return new RandomRule();
    }*/
}