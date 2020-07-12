package com.modules.service.impl;

import com.modules.dao.UserDao;
import com.modules.entities.User;
import com.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> getAll(String username) {
        List<User> list=userDao.getUser(username);
        return list;
    }

    @Override
    public User user(Integer pid) {
        return userDao.getUserById(pid);
    }

    @Override
    public void save(User user) {
        if(user==null){
            throw new RuntimeException("user不能为空");
        }
        int row = userDao.updateUser(user);
        if(row!=1){
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    public void add(User user) {
        int row = userDao.addUser(user);
        if(row!=1){
            throw new RuntimeException("增加失败");
        }
    }

    @Override
    public void delete(Integer pid) {
        int row=userDao.deleteUserByPid(pid);
        if(row!=1){
            throw new RuntimeException("删除失败");
        }
    }

    @Override
    public String selectPassword(String username) {
        return userDao.selectPassword(username);
    }

    @Override
    public void updatePassword(String old,String news,String name) {


        System.out.println(old);
        System.out.println(news);
        System.out.println(name);
        if(news==null){
            throw new RuntimeException("新密码不能为空");
        }
        int row=userDao.updatePassword(old,news,name);
        if(row!=1){
            throw new RuntimeException("修改密码失败");
        }
    }


}
