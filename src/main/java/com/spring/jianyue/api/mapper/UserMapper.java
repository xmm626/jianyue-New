package com.spring.jianyue.api.mapper;

import com.spring.jianyue.api.entity.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "password", column = "password"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar"),
            @Result(property = "regtime", column = "regtime"),
            @Result(property = "token", column = "token"),
            @Result(property = "status", column = "status")
    })
    @Select("SELECT * FROM t_user WHERE mobile = #{mobile} ")
    User getUserByMobile(String mobile);

    @Update("UPDATE t_user SET password=#{password},nickname=#{nickname},avatar=#{avatar},status=#{status},token=#{token} WHERE id =#{id}")
    void update(User user);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "password", column = "password"),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar"),
            @Result(property = "regtime", column = "regtime"),
            @Result(property = "token", column = "token"),
            @Result(property = "status", column = "status")
    })
    @Select("SELECT * FROM t_user WHERE id = #{id} ")
    User getUserById(Integer userId);

    @Insert("INSERT INTO t_user(mobile,password,nickname,status,regtime,avatar)" +
            " VALUES(#{mobile},#{password},#{nickname},#{status},#{regtime},#{avatar}) ")
    void insert(User user);

}
