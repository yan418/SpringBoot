package com.modules.service;


import com.modules.entities.BillVo;

import java.util.List;

public interface BillService {


    List<BillVo> getAll(String billName, Integer pay, Integer pid);

    BillVo getBillByBid(Integer bid);

    void save(BillVo billVo);

    void add(BillVo billVo);

    void delete(Integer bid);

}
