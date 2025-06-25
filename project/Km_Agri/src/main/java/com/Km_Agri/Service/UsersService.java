package com.Km_Agri.Service;

import com.Km_Agri.Entities.UsersEntity;
import com.Km_Agri.Mapper.UsersMapper;
import com.Km_Agri.Utils.StringConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class UsersService {

    @Autowired
    private UsersMapper usersMapper;

    public UsersEntity addUser(UsersEntity usersEntity){
        usersMapper.insertUsers(usersEntity);
        usersEntity=usersMapper.getUsersByID(usersEntity.getId());
        return usersEntity;
    }

    public UsersEntity getUsersById(int id){
        UsersEntity usersEntity=usersMapper.getUsersByID(id);
        if(usersEntity!=null) return usersEntity;
        throw new NoSuchElementException("No user Found with given Info");
    }



}
