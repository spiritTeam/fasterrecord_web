package com.energylabel.fastrecord.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.energylabel.fastrecord.exception.APIBasicException;
import com.energylabel.fastrecord.vo.ErrorVO;

import javax.servlet.http.HttpServletResponse;

import static com.energylabel.fastrecord.exception.APIErrorEnum.UNKNOWN_ERROR;

@ControllerAdvice
public class GlobalExceptionController {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionController.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorVO> exception(Exception exception, HttpServletResponse response) {
        ErrorVO dto;
        if (exception instanceof APIBasicException) {
            APIBasicException apie = (APIBasicException) exception;
            dto = new ErrorVO(apie.getCode(), apie.getMessage());
        } else {
            dto = new ErrorVO(UNKNOWN_ERROR.getCode(), UNKNOWN_ERROR.getDesc());
        }
        logger.error(dto.toString(),exception);
        return new ResponseEntity<>(dto, HttpStatus.valueOf(response.getStatus()));
    }
}
