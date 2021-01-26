package com.zww.ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * product表的动态sql拼接类
 */
public class ProductSqlProvider {
    public String deleteByIds(@Param("ids")Integer[] ids) {

        /*
         * SQL对象并不能满足所有的业务需求，只能拼接完成常见比较简单的动态SQL
         * 如果是比较复杂业务需求，还需要开发者自己拼接SQL
         * 	如：批量删除，批量插入
         *
         * */

        //delete from user where id in(?,?,?)
        SQL sql = new SQL();
        sql.DELETE_FROM("product"); // delete from user

        //拼接条件: (#{ids[0]},#{ids[1]},#{ids[2]})
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i = 0; i < ids.length; i++) {
            sb.append("#{ids["+i+"]},");
        }
        //删除最后一个多余的逗号
        sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        System.out.println(sb.toString());
        //条件
        sql.WHERE("id in"+sb.toString());
        System.out.println("SQL:"+sql.toString());
        return sql.toString();

    }
}
