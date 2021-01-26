package com.zww.ssm.dao;

import com.zww.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {
    /**
     * 根据id查会员
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from member where id = #{id}")
    Member findMemberById(String id) throws Exception;
}
