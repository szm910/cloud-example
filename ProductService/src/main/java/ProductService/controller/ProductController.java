package ProductService.controller;

import ProductService.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping(value="/product")
public class ProductController {

    private final Logger logger= Logger.getLogger(getClass().toString());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value="/getProduct", method = RequestMethod.GET)
    public Product getProduct(Long id){
        ServiceInstance instance=client.getLocalServiceInstance();
        Product p=new Product();
        p.setCode("123");
        p.setName("pname");
        return p;
    }
}
