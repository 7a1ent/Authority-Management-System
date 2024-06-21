package com.example.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sys.entity.Account;
import com.example.sys.entity.User;
import com.example.sys.mapper.UserMapper;
import com.example.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private UserMapper userMapper;
//查询操作
    @GetMapping("/api/getUserList")
    public List<User> getUserList(){

        List<User> list = userService.list();
        return list;

    }


    @GetMapping("/api/getUserById")
    public List<User> getUserById (String id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",id);


        List<User> list = userMapper.selectList(wrapper);

        return list;

    }


//    getUserByName


    @GetMapping("/api/getUserByName")
    public List<User> getUserByName (String name) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name",name);


        List selectList = userMapper.selectList(wrapper);

        System.out.println(selectList);

        return selectList;

    }

    //根据ID删除
    @GetMapping("/api/deleteById")
    public int deleteById (String id) {

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",id);
        return userMapper.deleteById(id);
    }

// 添加对象
    @GetMapping("/api/insert")
    public int insert (@RequestParam("id") String id,
                        @RequestParam("name") String name,
                        @RequestParam("gender") String gender,
                        @RequestParam("age") int age,
                        @RequestParam("privilege") int privilege){
        User user01 = new User();

        user01.setId(id);
        user01.setName(name);
        user01.setGender(gender);
        user01.setAge(age);
        user01.setPrivilege(privilege);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",id);


        List<User> list = userMapper.selectList(wrapper);

        if (list.size() > 0) {
            return 0;
        }

        return userMapper.insert(user01);




    }

    @GetMapping("/api/userUpdate")
    public int actUpdate (@RequestParam("id") String id,
                          @RequestParam("name") String name,
                          @RequestParam("age") int age,
                          @RequestParam("gender") String gender,
                          @RequestParam("privilege") int privilege){

        User user = new User();

        user.setId(id);
        user.setName(name);
        user.setAge(age);
        user.setGender(gender);
        user.setPrivilege(privilege);


        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",id);

        userService.remove(wrapper);

        return userMapper.insert(user);

    }
}
