package com.spring.jianyue.api.task;

import org.junit.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.junit.Assert.*;
@SpringBootApplication
public class TaskServiceTest {

    @Test
    public void proces() {
        TaskService taskService=new TaskService();
        taskService.proces();
    }
}