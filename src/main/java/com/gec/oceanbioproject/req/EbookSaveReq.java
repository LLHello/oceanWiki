package com.gec.oceanbioproject.req;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EbookSaveReq {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @NotNull(message = "【名称】不能为空")
    private String name;
    private Long category1Id;
    private Long category2Id;
    private String description;
    private String cover;
    private Integer docCount;
    private Integer viewCount;
    private Integer voteCount;
}
