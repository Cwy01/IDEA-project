package com.idea.restful.service;

import com.idea.restful.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

}