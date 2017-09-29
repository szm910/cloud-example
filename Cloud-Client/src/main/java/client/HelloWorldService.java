package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloWorldService {
    @Autowired
    RestTemplate restTemplate;

    final String SERVICE_NAME="hello-service";

    public  String hello() {
        System.out.println("Hello client request start !");
        String result = restTemplate.getForObject("http://"+SERVICE_NAME+"/hello", String.class);
        return result;
    }
}
