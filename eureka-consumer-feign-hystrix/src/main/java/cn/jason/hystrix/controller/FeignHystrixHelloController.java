package cn.jason.hystrix.controller;

import cn.jason.hystrix.service.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: FeignHystrixHelloController
 * @author: Jason
 * @Date: 2020/2/19 22:30
 * @Description: TODO 使用Spring Cloud提供的负载均衡器（Feign）客户端接口来实现服务的消费
 */
@RequestMapping("FeignHystrixHello")
@RestController
public class FeignHystrixHelloController {

/*@Qualifier("eureka-producer")*/

    @Autowired
    HelloRemote helloRemote;

    @GetMapping("/gatewayTest")
    public String gatewayTest(@RequestParam String a,@RequestParam String b) {
        return helloRemote.hello(a+";"+b+";" + "!《FeignHystrix》");
    }

    @GetMapping("/index")
    public String index(@RequestParam String name) {
        return helloRemote.hello(name + "!《FeignHystrix》");
    }
}
