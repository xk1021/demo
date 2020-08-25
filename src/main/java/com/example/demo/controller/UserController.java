package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Resource
    UserService userService;



    // 查询所有
    @GetMapping("/user/userList")
    public Map<String, Object> listUser() {
        Map<String, Object> map = new HashMap<>();

        List<User> list = userService.findAll();
        map.put("userList", list);
        return map;
    }

    // 根据id查询
    @GetMapping("/user/findUserById")
    public Map<String, Object> findUserById(Integer id) {
        Map<String, Object> map = new HashMap<>();
        User user = userService.findUserById(id);
        map.put("user", user);
        return map;
    }


    // 修改用户
    @PostMapping("/user/updateUser")
    public Map<String, Object> updateUser(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", userService.updateUser(user));
        return map;
    }

    // 添加用户
    @PostMapping("/user/addUser")
    public Map<String, Object> addUser(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", userService.addUser(user));
        return map;
    }

    // 删除用户
    @GetMapping("/user/deleteUser")
    public Map<String, Object> deleteUser(Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", userService.deleteUser(id));
        return map;
    }
}
