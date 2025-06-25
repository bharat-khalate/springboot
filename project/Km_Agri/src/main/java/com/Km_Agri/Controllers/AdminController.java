package com.Km_Agri.Controllers;

import com.Km_Agri.Dto.Requests.RegisterExpertReqDto;
import com.Km_Agri.Dto.Requests.RegisterUserReqDto;
import com.Km_Agri.Dto.Response.RegisterExpertResDto;
import com.Km_Agri.Dto.Response.RegisterUserResDto;
import com.Km_Agri.Dto.SuccessResponseDto;
import com.Km_Agri.Entities.CropEntity;
import com.Km_Agri.Service.CommonService;
import com.Km_Agri.Service.CropService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private CropService cropService;

    @Autowired
    private CommonService commonService;

    @PostMapping("/createcrop")
    public ResponseEntity<?> createCrop(@Valid @RequestBody CropEntity cropEntity){
        cropEntity=cropService.createCrop(cropEntity);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponseDto(true,"Crop Created SuccessFully", List.of(cropEntity)));
    }

    @PostMapping(value="/createexpert",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createExpert(@Valid @ModelAttribute RegisterExpertReqDto registerExpertReqDto, @RequestParam("file") MultipartFile file){
        System.out.println(file);
        registerExpertReqDto.setRoll("EXPERT");
        RegisterExpertResDto registerExpertResDto =commonService.createExperts(registerExpertReqDto,file);
        SuccessResponseDto successResponseDto=new SuccessResponseDto(true,"Expert Created Successfully", List.of(registerExpertResDto));
        return ResponseEntity.status(HttpStatus.OK).body(successResponseDto);
    }
}