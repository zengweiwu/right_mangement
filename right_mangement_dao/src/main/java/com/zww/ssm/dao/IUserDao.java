package com.zww.ssm.dao;

import com.zww.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * user数据库操作类
 */
public interface IUserDao {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.zww.ssm.dao.RoleDao.findRoleByUserId"))

    })
    UserInfo findUserByUserName(String username);
}
