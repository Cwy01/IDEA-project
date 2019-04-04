package com.idea.restful.controller;

import com.idea.restful.dao.UserDao;
import com.idea.restful.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;
    private User user;

    public UserController(){
       user =  new User();
    }

    @GetMapping("/user")
    public List<User> user() {
        return userDao.findAll();
    }

    @GetMapping(value="/user/{id}")
    public Optional<User> userById(@PathVariable("id") String id) {
        return userDao.findById(id);
    }

    @PostMapping("/user")
    public void user(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("info") String info) {
        //user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        user.setId(id);
        user.setName(name);
        user.setInfo(info);
        userDao.save(user);
    }

    @DeleteMapping("/user")
    public void user(@RequestParam("id") String id) {
        userDao.deleteById(id);
    }

    @PutMapping("/user")
    public Optional<User> user(@RequestParam("id") String id,  @RequestParam("info") String info){
        return userDao.findById(id);
    }

}