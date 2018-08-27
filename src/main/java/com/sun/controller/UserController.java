package com.sun.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.sun.entity.User;
import com.sun.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserMapper userMapper;

    @GetMapping("/findUserById")
    public void findUserById(Integer id){
       User user= userMapper.selectByPrimaryKey(id);
        System.out.print(JSONObject.toJSONString(user));

    }

    @GetMapping("/findPageUser")
    public  void  findPageUser(){
        PageHelper.startPage(1, 10);
        List<User> list=userMapper.selectAllUser();
        System.out.print(JSONObject.toJSONString(list));

    }



}
