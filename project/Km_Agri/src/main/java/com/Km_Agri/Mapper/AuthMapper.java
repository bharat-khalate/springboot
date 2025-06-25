package com.Km_Agri.Mapper;

import com.Km_Agri.Entities.AuthEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AuthMapper {


    @Insert("insert into auth (id,user_name,password,roll) values(#{id},#{userName},#{password},#{roll})")
    void insertAuth(AuthEntity authEntity);

    @Select("select * from auth where id=#{id}")
    AuthEntity getAuthById(int id);

    @Select("select * from auth where user_name=#{userName} and password=#{password}")
    AuthEntity getAuth(AuthEntity authEntity);

    @Select("select * from auth where user_name=#{userName}")
    AuthEntity getAuthByUserName(String userName);


}
