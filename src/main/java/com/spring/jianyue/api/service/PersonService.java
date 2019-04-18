package com.spring.jianyue.api.service;

import com.spring.jianyue.api.entity.Person;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PersonService {
    List<Person> selectUsers();
    boolean batchImport(String fileName, MultipartFile file) throws Exception;
}
