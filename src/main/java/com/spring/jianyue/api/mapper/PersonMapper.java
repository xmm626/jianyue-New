package com.spring.jianyue.api.mapper;

import com.spring.jianyue.api.entity.Person;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface PersonMapper {
    @Results({
            @Result(property = "uid", column = "u_id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password")
    })
    @Select("SELECT * FROM t_person WHERE u_id = #{uid} ")
    Person getLike(@Param("uid") int uid);
}
