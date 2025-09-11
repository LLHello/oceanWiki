package com.gec.oceanbioproject.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Result<T> {
    //业务上的成功或失败
    private boolean success = true;
//    private boolean fail = false;
    //返回信息
    private String message;
    //返回泛型数据，自定义类型
    private T content;
    public Result(boolean success, String message, T content) {
        this.success = success;
        this.message = message;
        this.content = content;
    }
}
