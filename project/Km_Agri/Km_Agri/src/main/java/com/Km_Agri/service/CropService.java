package com.Km_Agri.service;

import com.Km_Agri.entities.Crop;
import com.Km_Agri.repository.CropRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CropService {
    private final CropRepository cropRepository;

    public Crop addCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }

    public Crop getCropById(Long cropId) {
        return cropRepository.findById(cropId).orElseThrow(() -> new NoSuchElementException("Invalid crop id"));
    }

    public Crop updateCropById(Long cropId, Crop crop) {
        Crop oldCrop = cropRepository.findById(cropId).orElseThrow(() -> new NoSuchElementException("Invalid crop id"));
        if (!crop.getName().equals(oldCrop.getName())) oldCrop.setName(crop.getName());
        return cropRepository.save(oldCrop);
    }

    public boolean deleteCropById(Long cropId) {
        this.getCropById(cropId);
        cropRepository.deleteById(cropId);
        return true;
    }


}
