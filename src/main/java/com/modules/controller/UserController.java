package com.modules.controller;


import com.modules.entities.User;
import com.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    /**
     * 查询列表
     * @param username 供应商名称，查询单条
     * @return 列表
     */
    @GetMapping("/list")
    public String list(@RequestParam(value = "username",required = false) String username, Model model){
        System.out.println("list++");
        List<User> list=userService.getAll(username);
        Map<String,Object> map =new HashMap();
        map.put("name",username);
        map.put("userList",list);
        model.addAllAttributes(map);
        return "home/list";
    }

    /**
     * 查看一条数据 / 修改页面
     * @param id 主键ID
     * @param type 状态 为view 查看页面，update为修改页面 ,
     * @return
     * */
    @GetMapping("/user/{id}")
    public String provider(@PathVariable("id") Integer id,@RequestParam(value = "type",defaultValue = "view") String type,Map<String,Object> map){
        //System.out.println(id);
        //System.out.println(type);
        User user=userService.user(id);
        map.put("user",user);
        return "user/" + type;
    }

    /**
     * 修改操作
     * @param
     * @return
     */
    @PutMapping("/user")
    public String update(User user){
        //时间spring接受时间默认是2019/12/22
        userService.save(user);
        //重定向
        return "redirect:/users";
    }

    /**
     * 前往添加页面
     * @return
     */
    @GetMapping("/user")
    public String addUser(){
        return "user/add";
    }


    /**
     * 创建操作
     * @param user
     * @return
     */
    @PostMapping("/user")
    public String add(User user) {
        if(user.getRealName()!=null){
            userService.add(user);
        }
        return "redirect:/users";
    }

    /**
     * 删除操作
     * @param id
     * @return
     */
    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") Integer id) {
        if(id>0){
            userService.delete(id);
        }
        return "redirect:/users";
    }

    @GetMapping("/user/pwd")
    public String toUpdatePwdPage() {
        return "main/password";
    }

    @ResponseBody
    @GetMapping("/user/pwd/{oldPassword}")
    public Boolean oldPassword(HttpSession session, @PathVariable("oldPassword") String oldPassword) {
        if(oldPassword!=null){
            Object loginState = session.getAttribute("LoginState");
            String pass=userService.selectPassword(loginState.toString());
            if(oldPassword.equals(pass)){
                return true;
            }
        }
        return false;
    }

    /**
     * 保持密码
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @PostMapping("/user/pwd")
    public String add(HttpSession session,@RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword) {
        Object name = session.getAttribute("LoginState");
        userService.updatePassword(oldPassword,newPassword,name.toString());
        return "redirect:/doQuit";
    }

}
