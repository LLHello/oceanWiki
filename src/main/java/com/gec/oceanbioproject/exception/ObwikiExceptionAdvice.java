package com.gec.oceanbioproject.exception;

import com.gec.oceanbioproject.resp.Result;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;
@Slf4j
@RestControllerAdvice(basePackages = "com.gec.obwiki.controller")
public class ObwikiExceptionAdvice {
//    private static final Logger log = LoggerFactory.getLogger(ObwikiExceptionAdvice.class);
    //编写异常处理方法
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handleVaildException(MethodArgumentNotValidException e){
//        log.info("数据校验出现问题{},异常类型{}",e.getMessage(),e.getClass());
        BindingResult result = e.getBindingResult();
        Map<String,String> errorMap=new HashMap<>();
        result.getFieldErrors().forEach((item)->{
            String field = item.getField();
            String message = item.getDefaultMessage();
            errorMap.put(field,message);
        });
        return new Result(false,"数据校验异常",errorMap);
    }
    //处理自定义异常
    @ExceptionHandler(BusinessException.class)
    public Result handlerBusinessException(BusinessException e){
//        log.error(e.getCode().getDesc(),e);
        return new Result(false,e.getCode().getDesc(),null);
    }
    //处理 系统异常
    @ExceptionHandler(Exception.class)
    public Result handlerException(Exception e){
//        log.error(e.getMessage(),e);
        return new Result(false,"未知异常,请联系管理员",null);
    }
}
