package com.idea.test.service;


import com.idea.test.pojo.Status;
import com.idea.test.pojo.TableStatus;

public interface VueService {

	Status topics();
	Status topic();
	Status pieDatas();
	TableStatus tableDatas();
}