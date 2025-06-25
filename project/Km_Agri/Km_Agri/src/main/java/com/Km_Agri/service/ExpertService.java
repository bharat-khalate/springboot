package com.Km_Agri.service;

import com.Km_Agri.entities.Expert;
import com.Km_Agri.repository.ExpertRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ExpertService {
    private ExpertRepository expertRepository;

    public Expert addExpert(Expert expert) {
        return expertRepository.save(expert);
    }

    public List<Expert> getAllExperts() {
        return expertRepository.findAll();
    }

    public Expert getExpertById(Long expertId) {
        return expertRepository.findById(expertId).orElseThrow(() -> new NoSuchElementException("No expert found with given details"));
    }

    public Expert updateExpertById(Long expertId, Expert expert) {
        Expert oldExpert = this.getExpertById(expertId);
        if (expert.getRatings() != null) oldExpert.setRatings(expert.getRatings());
        if (expert.getExperience() != null) oldExpert.setExperience(expert.getExperience());
        return expertRepository.save(oldExpert);
    }
}
