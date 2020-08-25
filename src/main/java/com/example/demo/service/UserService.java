package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {


    @Resource
    UserMapper userMapper;

    // 查询全部
    public List<User> findAll() {
     return   userMapper.selectAll();
    }

    // 根据id 查询用户
    public User findUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    // 添加
    public Boolean addUser(User user) {
        int count = userMapper.insert(user);
        return count == 1;
    }

    // 修改
    public Boolean updateUser(User user) {
        int i = userMapper.updateByPrimaryKey(user);
        return i == 1;
    }

    // 删除
    public Boolean deleteUser(Integer id) {
        int i = userMapper.deleteByPrimaryKey(id);
        return i == 1;
    }
}
