package orderservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    @Autowired
    RestTemplate restTemplate;

    final String SERVICE_NAME="product-service";

    @HystrixCommand(fallbackMethod = "error")
    @RequestMapping(value="/submitOrder", method = RequestMethod.GET)
    public String submitOrder(){
        System.out.println("hhhhhhhhhhhh--------------hhhhhhhhhh");
        String result = restTemplate.getForObject("http://"+SERVICE_NAME+"/product/getProduct", String.class);
        return result;
    }
    public String error(){
        return "error";
    }
}
