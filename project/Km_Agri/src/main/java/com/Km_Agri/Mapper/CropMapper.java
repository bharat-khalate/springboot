package com.Km_Agri.Mapper;

import com.Km_Agri.Entities.CropEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface CropMapper {

    @Insert("insert into crop (name) values(#{name})")
    @Options(useGeneratedKeys = true,keyProperty ="cropId", keyColumn="crop_id" )
    void insertCrop(CropEntity cropEntity);
}
