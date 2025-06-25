package com.Km_Agri.Mapper;

import com.Km_Agri.Entities.UsersEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UsersMapper {

    @Insert("insert into users (phone_no,profile_picture) values (#{phoneNumber},#{profilePicture})")
    @Options(useGeneratedKeys = true,keyProperty = "id", keyColumn = "id")
    void insertUsers(UsersEntity users);

    @Select("select * from users where id=#{id}")
    UsersEntity getUsersByID(int id);

    @Update("update users set (phone_no,profile_picture,status,last_seen) values(#{phoneNumber},#{profilePicture},#{status},#{lastSeen}) where id=#{id}")
    void updateUsersAllInfo(UsersEntity usersEntity);



}
