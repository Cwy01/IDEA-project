package com.idea.test.service;


import com.idea.test.pojo.Article;
import com.idea.test.pojo.Status;
import com.idea.test.pojo.TableStatus;

public interface VueService {

	Status getTopics();
	Status postTopics(Article article);
	Status putTopics();
	Status deleteTopics();
	Status topic(String id);
	Status pieDatas();
	TableStatus tableDatas();
}