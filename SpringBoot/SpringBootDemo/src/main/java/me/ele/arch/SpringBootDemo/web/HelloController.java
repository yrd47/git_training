package me.ele.arch.SpringBootDemo.web;

import me.ele.arch.SpringBootDemo.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by yrd on 2017/5/22.
 *
 */

@RestController
public class HelloController {

    private static final String tmeplate = "Hi, %s! Let's fuck the GFW";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/hello")
    public String home() throws Exception{
        return "Hello World";
//    	throw new Exception("发生错误");
    }

    @RequestMapping(value = "/fuck")
    public @ResponseBody User sayFuck(@RequestParam(value = "name" ,required = false , defaultValue = "Stranger") String name){
        return new User(counter.incrementAndGet(),String.format(tmeplate,name),12);
    }
}
