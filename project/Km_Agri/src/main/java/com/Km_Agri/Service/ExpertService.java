package com.Km_Agri.Service;

import com.Km_Agri.Entities.ExpertEntity;
import com.Km_Agri.Mapper.ExpertMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpertService {

    @Autowired
    private ExpertMapper expertMapper;

    public ExpertEntity addExpert(ExpertEntity expertEntity){
        expertMapper.insertExpert(expertEntity);
        expertEntity=expertMapper.getExpertsById(expertEntity.getId());
        return expertEntity;
    }
}
