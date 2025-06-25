package com.Km_Agri.repository;

import com.Km_Agri.entities.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepository extends JpaRepository<Crop,Long> {
}
