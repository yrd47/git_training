package me.ele.arch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yrd on 2017/5/22.
 *
 */

@RestController
@EnableAutoConfiguration
public class Example {

    @RequestMapping("/")
    String home(){
        return "Hello World";
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(Example.class,args);
    }

}
