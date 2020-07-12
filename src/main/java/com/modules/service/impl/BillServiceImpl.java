package com.modules.service.impl;

import com.modules.dao.BillDao;
import com.modules.entities.BillVo;
import com.modules.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillDao billDao;

    @Override
    public List<BillVo> getAll(String billName, Integer pay, Integer pid) {

        BillVo b = new BillVo();
        b.setBillName(billName);
        b.setPay(pay);
        b.setPid(pid);

        List<BillVo> list = billDao.getBill(b);
        return list;
    }

    @Override
    public BillVo getBillByBid(Integer bid) {
        BillVo bill = billDao.getBillByBid(bid);
        return bill;
    }

    @Override
    public void save(BillVo billVo) {
        if(billVo==null){
            throw new RuntimeException("bill不能为空");
        }
        billVo.setCreateDate(new Date());
        int row = billDao.updateBillVo(billVo);
        if(row!=1){
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    public void add(BillVo billVo) {
        int row = billDao.addBillVo(billVo);
        if(row!=1){
            throw new RuntimeException("增加失败");
        }
    }

    @Override
    public void delete(Integer bid) {
        int row=billDao.deleteBillVoByPid(bid);
        if(row!=1){
            throw new RuntimeException("删除失败");
        }
    }


}
