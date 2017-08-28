package me.ele.arch.SpringBootDemo.web;

import me.ele.arch.SpringBootDemo.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by yrd on 2017/5/22.
 *
 */

@RestController
@RequestMapping(value = "/users")
public class UserController {

    static Map<Long,User> users = Collections.synchronizedMap(new HashMap<Long,User>());

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public List<User> getUserList(){
        //处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        List<User> userList = new ArrayList<User>(users.values());
        return userList;
    }

    @RequestMapping(value = "/" , method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        users.put(user.getId(),user);
        return "success";
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return users.get(id);
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id,@ModelAttribute User user){
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        User userNew = users.get(id);
        userNew.setName(user.getName());
        userNew.setAge(user.getAge());
        users.put(id, userNew);
        return "success";
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id){
        // 处理"/users/{id}"的DELETE请求，用来删除User
        users.remove(id);
        return "success";
    }
}




