package com.sky.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "員工登錄返回的資料格式")
public class EmployeeLoginVO implements Serializable {

    @ApiModelProperty("主鍵值")
    private Long id;

    @ApiModelProperty("用戶名")
    private String userName;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("jwt權杖")
    private String token;

}

