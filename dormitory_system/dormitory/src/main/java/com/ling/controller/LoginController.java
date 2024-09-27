package com.ling.controller;

import com.ling.entity.Student;
import com.ling.entity.User;
import com.ling.framework.jwt.JWTUtil;
import com.ling.service.StudentService;
import com.ling.service.UserService;
import com.ling.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        if(user.getType() == 2){ //学生登录的
            Student entity = studentService.login(user.getUserName(),user.getPassword());
            if(entity != null){
                String token = JWTUtil.signForStudent(entity);
                Map map = new HashMap();
                map.put(JWTUtil.token,token);
                map.put("student",entity);
                return Result.ok("登陆成功",map);
            }else{
                return Result.fail("用户名或密码错误");
            }
        }else{//管理员与宿管员登录
            User entity = userService.login(user.getUserName(),user.getPassword());
            if(entity != null){
                String token = JWTUtil.sign(entity);
                Map map = new HashMap();
                map.put(JWTUtil.token,token);
                map.put("user",entity);
                return Result.ok("登陆成功",map);
            }else{
                return Result.fail("用户名或密码错误");
            }
        }
    }

    @GetMapping("/open-api/ddd")
    public void test(){
        System.out.println("ddd");
    }


}
