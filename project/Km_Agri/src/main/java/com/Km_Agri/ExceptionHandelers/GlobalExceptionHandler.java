package com.Km_Agri.ExceptionHandelers;

import com.Km_Agri.Dto.ErrorInfoRes;
import com.Km_Agri.Dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex){
        ex.printStackTrace();
        ErrorInfoRes errorInfoRes=new ErrorInfoRes(400,ex.getLocalizedMessage());
        ErrorResponseDto errorResponseDto=new ErrorResponseDto(false,"internal server ErrorRecord", List.of(errorInfoRes));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDto);
    }

}
