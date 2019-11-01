package com.xhy.angel.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Valid
@ApiModel(description = "添加Car输入请求")
public class CarRequest {
    @ApiModelProperty(value="ID", required = true, example = "1234567890")
    @JsonProperty("id")
    @Length(max = 32)
    @NotNull
    private Long id;

    @ApiModelProperty(value = "name", required = true, example="车名")
    @JsonProperty("name")
    @Length(max = 62)
    @NotNull
    private String name;
}
