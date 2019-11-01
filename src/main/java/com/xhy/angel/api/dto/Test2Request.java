package com.xhy.angel.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Valid
@ApiModel(description = "测试HelloWorld查询请求输入")
public class Test2Request {
    @ApiModelProperty(value="UUID", required = true, dataType = "string", example = "1234567890")
    @Length(max = 32)
    @NotNull
    private String uuid;

    @ApiModelProperty(value = "姓名", required = true, example="姓名")
    @Length(max = 62)
    @NotNull
    private String name;

    @ApiModelProperty(value = "时间", required = true, example = "2019-09-26 11:00:03")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull
    private LocalDateTime dateTime;

}
