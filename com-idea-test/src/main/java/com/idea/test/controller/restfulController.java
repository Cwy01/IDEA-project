package com.idea.test.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.idea.test.pojo.Article;
import com.idea.test.pojo.Status;
import com.idea.test.service.VueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class restfulController {
    @Autowired
    private VueService vueService;

    @GetMapping("/api/v1/topics")
    Status getTopics() {
        return vueService.getTopics();
    }

    @GetMapping("/api/v1/topic/{id}")
    Status findTopicById(@PathVariable("id")String id) {
        return vueService.topic(id);
    }

    @PostMapping("/api/v1/topics")
    Status postTopics(@RequestBody Article article) {
        return vueService.postTopics(article);
    }

    @PutMapping("/api/v1/topics")
    Status putTopics() {

        return vueService.putTopics();
    }

    @DeleteMapping("/api/v1/topics")
    Status deleteTopics() {

        return vueService.deleteTopics();
    }
}
