package com.modules.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 供应商实体类
 * @Title: Provider
 * @Version: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("供应商实体类")
public class Provider implements Serializable {

    @ApiModelProperty("id")
    private Integer pid;
    //供应商编码
    @ApiModelProperty("供应商编码")
    private String providerCode;
    //供应商名称
    @ApiModelProperty("供应商名称")
    private String providerName;
    //联系人
    @ApiModelProperty("联系人")
    private String people;
    //联系电话
    @ApiModelProperty("联系电话")
    private String phone;
    //联系地址
    @ApiModelProperty("地址")
    private String address;
    //传真
    @ApiModelProperty("传真")
    private String fax;
    //描述
    @ApiModelProperty("描述")
    private String describe;
    // 创建时间
    @ApiModelProperty("创建时间")
    private Date createDate;


}
