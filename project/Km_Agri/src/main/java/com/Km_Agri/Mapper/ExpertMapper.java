package com.Km_Agri.Mapper;

import com.Km_Agri.Entities.ExpertEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ExpertMapper {

    @Insert("insert into experts (id,crop_id,experience) values(#{id},#{cropId},#{experience})")
    void insertExpert(ExpertEntity expertEntity);

    @Select("select * from experts where id=#{id}")
    ExpertEntity getExpertsById(int id);

}
