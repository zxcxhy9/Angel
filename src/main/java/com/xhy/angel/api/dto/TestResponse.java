package com.xhy.angel.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
//@Validated
@ApiModel(description = "测试HelloWorld查询请求响应")
public class TestResponse {
    @ApiModelProperty("UUID")
    //@JsonProperty("uuid")
    private String uuid;

    @ApiModelProperty("姓名")
    //@JsonProperty("name")
    private String name;

    @ApiModelProperty(value = "时间", required = true, example = "2019-09-26 11:00:03")
    //@JsonProperty("dateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;
}
