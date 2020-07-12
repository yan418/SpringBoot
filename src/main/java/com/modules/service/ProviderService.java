package com.modules.service;

import com.modules.entities.Provider;

import java.util.List;

public interface ProviderService {

    List<Provider> getAll(String providerName);

    Provider provider(Integer pid);

    void save(Provider provider);

    void add(Provider provider);

    void delete(Integer pid);

}
