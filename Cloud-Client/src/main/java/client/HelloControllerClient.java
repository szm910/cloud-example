package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllerClient {
    @Autowired
    HelloWorldService service;

    @RequestMapping(value="/hello")
    public ResponseEntity<String> hello(){
        String result=service.hello();
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }
}
