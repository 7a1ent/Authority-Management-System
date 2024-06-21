package com.example.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sys.entity.Account;
import com.example.sys.mapper.ActMapper;
import com.example.sys.mapper.UserMapper;
import com.example.sys.service.ActService;
import com.example.sys.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ActController {

    @Autowired
    private ActService actService;


    @Autowired
    private ActMapper actMapper;

    //查询操作
    @GetMapping("/api/getActList")
    public List<Account> getUserList(){

        List<Account> list = actService.list();
        return list;

    }


    @GetMapping("/api/getActById")
    public List<Account> getActById (String act) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("act",act);


        List<Account> list = actMapper.selectList(wrapper);

        return list;

    }




//根据姓名参数查询权限账号信息
    @GetMapping("/api/getActByName")
    public List<Account> getActByName (String name) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name",name);


        List selectList = actMapper.selectList(wrapper);

        System.out.println(selectList);

        return selectList;

    }

    //根据ID删除
    @GetMapping("/api/actDeleteById")
    public boolean deleteById (String act) {

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("act",act);
        return actService.remove(wrapper);
    }

    // 添加对象
    @GetMapping("/api/actInsert")
    public int insert (@RequestParam("act") String act,
                       @RequestParam("name") String name,
                       @RequestParam("password") String password,
                       @RequestParam("privilege") int privilege){
        Account account = new Account();

        account.setAct(act);
        account.setName(name);
        account.setPassword(password);
        account.setPrivilege(privilege);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("act",act);

        List<Account> list = actMapper.selectList(wrapper);

        if (list.size() > 0) {
            return 0;
        }
        return actMapper.insert(account);

    }

    //登录
    @GetMapping("/api/confirm")
    public int confirm (@RequestParam("act") String act,
                       @RequestParam("password") String password,
                       @RequestParam("privilege") int privilege){
        Account account = new Account();

        account.setAct(act);
        account.setPassword(password);
        account.setPrivilege(privilege);

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("act",act);

        List<Account> list = actMapper.selectList(wrapper);

        if (list.size() == 0)
            return 0;

        Account act1 = list.get(0);

        if (act1.getPassword().equals(password) && act1.getAct().equals(act) && act1.getPrivilege().equals(privilege)) {
            return 1;
        }

        return 0;

    }

    //编辑操作
    @GetMapping("/api/actUpdate")
    public int actUpdate (@RequestParam("act") String act,
                        @RequestParam("name") String name,
                        @RequestParam("password") String password,
                        @RequestParam("privilege") int privilege){
        System.out.println("update方法被调用");
        Account account = new Account();

        account.setAct(act);
        account.setName(name);
        account.setPassword(password);
        account.setPrivilege(privilege);

        System.out.println(account);

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("act",act);

        actService.remove(wrapper);

        return actMapper.insert(account);

    }




}
