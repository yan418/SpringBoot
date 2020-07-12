package com.modules.controller;


import com.modules.entities.Provider;
import com.modules.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    ProviderService providerService;

    /**
     * 事务管理
     * @return 列表
     */
    //指定隔离级别，传播方式
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @GetMapping("/tran")
    public String list(){
        /**
            开启事务管理后， 111 ，222 这两条数据并不能提交
         */
        Provider provider = new Provider();
        provider.setProviderName("111");
        providerService.add(provider);
        provider.setProviderName("222");
        providerService.add(provider);

        //new RuntimeException("模拟错误");

        provider.setProviderName("333");
        providerService.add(provider);
        provider.setProviderName("444");
        providerService.add(provider);

        return "succeed";
    }


}
