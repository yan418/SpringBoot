package com.modules.service.impl;

import com.modules.dao.ProviderDao;
import com.modules.entities.Provider;
import com.modules.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    ProviderDao providerDao;

    @Override
    public Provider provider(Integer pid) {
        return providerDao.getProviderByPid(pid);
    }

    @Override
    public void save(Provider provider) {
        if(provider==null){
            throw new RuntimeException("provider不能为空");
        }
        provider.setCreateDate(new Date());
        int row = providerDao.updateProvider(provider);
        if(row!=1){
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    public void add(Provider provider) {

        //模拟事务管理
        if(provider.getProviderName().equals("333")){
            throw new RuntimeException("增加失败");
        }


        int row = providerDao.addProvider(provider);
        if(row!=1){
            throw new RuntimeException("增加失败");
        }
    }

    @Override
    public void delete(Integer pid) {
        int row=providerDao.deleteProviderByPid(pid);
        if(row!=1){
            throw new RuntimeException("删除失败");
        }
    }

    @Override
    public List<Provider> getAll(String providerName) {
        List<Provider> list = providerDao.getProviders(providerName);
        return list;
    }

}
