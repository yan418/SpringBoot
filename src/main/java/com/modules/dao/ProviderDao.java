package com.modules.dao;

import com.modules.entities.Provider;

import java.util.List;

public interface ProviderDao {

    List<Provider> getProviders(String providerName);

    Provider getProviderByPid(Integer pid);

    int updateProvider(Provider provider);

    int addProvider(Provider provider);

    int deleteProviderByPid(Integer pid);



}
