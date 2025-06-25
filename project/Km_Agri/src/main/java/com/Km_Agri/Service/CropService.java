package com.Km_Agri.Service;

import com.Km_Agri.Entities.CropEntity;
import com.Km_Agri.Mapper.CropMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CropService {

    @Autowired
    private CropMapper cropMapper;

    public CropEntity createCrop(CropEntity cropEntity){
        cropMapper.insertCrop(cropEntity);
        return cropEntity;
    }
}
