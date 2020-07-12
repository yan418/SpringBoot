package com.modules.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 帐单实体类
 * @Version: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillVo extends Bill{

    private String providerName;

}
