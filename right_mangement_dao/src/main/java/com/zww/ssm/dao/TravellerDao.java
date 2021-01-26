package com.zww.ssm.dao;

import com.zww.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerDao {
    /**
     * 通过中间表查询游客
     * @param orderId
     * @return
     * @throws Exception
     */
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{orderId})")
    List<Traveller> findTravellersById(String orderId) throws Exception;
}
