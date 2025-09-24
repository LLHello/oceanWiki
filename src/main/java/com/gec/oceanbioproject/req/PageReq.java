package com.gec.oceanbioproject.req;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PageReq {
    @NotNull(message = "【页码】不能为空")
    private int page;
    @NotNull(message = "【每页条数】不能为空")
    @Max(value = 1000, message = "【每页条数】不能超过1000")
    private int size;
}