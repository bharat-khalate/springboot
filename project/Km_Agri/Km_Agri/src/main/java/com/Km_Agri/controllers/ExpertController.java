package com.Km_Agri.controllers;

import com.Km_Agri.dto.ResponseStructure;
import com.Km_Agri.entities.Expert;
import com.Km_Agri.service.ExpertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expert")
@RequiredArgsConstructor
public class ExpertController {
    private final ExpertService expertService;

    @GetMapping
    public ResponseEntity<?> getAllExperts() {
        return ResponseEntity.ok(new ResponseStructure(200, true, expertService.getAllExperts()));
    }

    @GetMapping("/{expertId}")
    public ResponseEntity<?> getExpertById(@PathVariable Long expertId) {
        return ResponseEntity.ok(new ResponseStructure(200, true, List.of(expertService.getExpertById(expertId))));
    }

    @PutMapping("/{expertId}")
    public ResponseEntity<?> updateExpert(@PathVariable Long expertId, @RequestBody Expert expert) {
        return ResponseEntity.ok(new ResponseStructure(200, true, List.of(expertService.updateExpertById(expertId, expert))));
    }

    
}
