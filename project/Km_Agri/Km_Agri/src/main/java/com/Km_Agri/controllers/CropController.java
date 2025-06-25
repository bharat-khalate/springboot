package com.Km_Agri.controllers;

import com.Km_Agri.dto.ResponseStructure;
import com.Km_Agri.entities.Crop;
import com.Km_Agri.service.CropService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/crop")
@RequiredArgsConstructor
public class CropController {
    private final CropService cropService;

    @GetMapping
    public ResponseEntity<?> getAllCrops() {
        List<Crop> cropList = cropService.getAllCrops();
        ResponseStructure responseStructure = new ResponseStructure(200, true, cropList);
        return ResponseEntity.ok(responseStructure);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getCrop(@PathVariable Long id) {
        return ResponseEntity.ok(new ResponseStructure(200, true, List.of(cropService.getCropById(id))));
    }

    @PostMapping
    public ResponseEntity<?> createCrop(@RequestBody Crop crop) {
        return ResponseEntity.ok(new ResponseStructure(200, true, List.of(cropService.addCrop(crop))));
    }

}
