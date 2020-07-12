package com.modules.controller;


import com.modules.entities.BillVo;
import com.modules.entities.Provider;
import com.modules.service.BillService;
import com.modules.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class BillController {

    @Autowired
    BillService billService;

    @Autowired
    ProviderService providerService;

    /**
     * 查询列表
     * @param
     * @return 列表
     */

    @GetMapping("/bills")
    public String list(@RequestParam(value = "billName",required = false) String billName,@RequestParam(value = "pay",required = false) Integer pay,@RequestParam(value = "pid",required = false) Integer pid, Map<String,Object> map){

        //查询供应商
        List<Provider> providers = providerService.getAll(null);
        List<BillVo> list = billService.getAll(billName,pay,pid);

        map.put("providers",providers);
        map.put("billList",list);
        map.put("billName",billName);
        map.put("pay",pay);
        map.put("pid",pid);
        return "bill/list";
    }


    /**
     * 查看一条数据 / 修改页面
     * @param bid 主键ID
     * @param type 状态 为view 查看页面，update为修改页面 ,
     * @return
     * */
    @GetMapping("/bill/{bid}")
    public String bill(@PathVariable("bid") Integer bid, @RequestParam(value = "type",defaultValue = "view") String type,Map<String,Object> map){

        System.out.println(bid);
        BillVo billVo = billService.getBillByBid(bid);

        if("update".equals(type)){
            //查询供应商
            List<Provider> providers = providerService.getAll(null);
            map.put("providers",providers);
        }

        map.put("billVo",billVo);
        return "bill/" + type;
    }

    /**
     * 修改操作
     * @param billVo
     * @return
     */
    @PutMapping("/bill")
    public String update(BillVo billVo){
        billService.save(billVo);
        //重定向
        return "redirect:/bills";
    }

    /**
     * 前往添加页面
     * @return
     */
    @GetMapping("/bill")
    public String addBill(Map<String,Object> map){
        //查询供应商
        List<Provider> providers = providerService.getAll(null);
        map.put("providers",providers);
        return "bill/add";
    }

    /**
     * 创建操作
     * @param billVo
     * @return
     */
    @PostMapping("/bill")
    public String add(BillVo billVo) {
        if(billVo.getPid()!=null){
            billService.add(billVo);
        }
        return "redirect:/bills";
    }

    /**
     * 删除操作
     * @param
     * @return
     */
    @DeleteMapping("/bill/{bid}")
    public String delete(@PathVariable("bid") Integer bid) {
        if(bid>0){
            billService.delete(bid);
        }
        return "redirect:/bills";
    }


}

