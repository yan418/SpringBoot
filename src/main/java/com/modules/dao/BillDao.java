package com.modules.dao;


import com.modules.entities.BillVo;

import java.util.List;

public interface BillDao {

    List<BillVo> getBill(BillVo billVo);

    BillVo getBillByBid(Integer bid);

    int updateBillVo(BillVo billVo);

    int addBillVo(BillVo billVo);

    int deleteBillVoByPid(Integer pid);

}
