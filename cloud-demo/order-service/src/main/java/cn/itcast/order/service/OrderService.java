package cn.itcast.order.service;

import cn.itcast.order.clients.UserClient;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserClient userclient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //2.用feign远程调用
        User user = userclient.findById(order.getUserId());
        //3.封装user到order
        order.setUser(user);
        // 4.返回
        return order;
    }
   /* public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //2.通过RestTemplat发起HTTP请求
        //2.1.url路径
        //String url = "http://localhost:127.0.0.1/user/" + order.getUserId();
        String url = "http://userservice/user/" + order.getUserId();//使用服务器名称实现软编码
        //2.2.发送url路径实现远程调用，并将返回josn对象转化为实体类对象
        User user = restTemplate.getForObject(url,User.class);
        //3.封装user到order
        order.setUser(user);
        // 4.返回
        return order;
    }*/
}
