package com.zww.ssm.dao;

import com.zww.ssm.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户角色关联表Dao
 */
public interface RoleDao {
    /**
     * 根据用户id查询角色
     * @param id
     * @return
     */
    @Select("select * from role where id in (select roleId from users_role where userId = #{id})")
     List<Role> findRoleByUserId(String id);
}
