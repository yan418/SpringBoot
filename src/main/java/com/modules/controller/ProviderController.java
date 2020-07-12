package com.modules.controller;

import com.modules.entities.Provider;
import com.modules.service.ProviderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "供应商")
@Controller
public class ProviderController {

    @Autowired
    ProviderService providerService;


    /**
     * 查询列表
     * @param providerName 供应商名称，查询单条
     * @return 列表
     */
    @ApiOperation("查询供应商列表")
    @GetMapping("/providers")
    public String list(@RequestParam(value = "providerName",required = false) String providerName, Map<String,Object> map){
        List<Provider> list=providerService.getAll(providerName);
        map.put("name",providerName);
        map.put("providerList",list);
        return "provider/list";
    }

    /**
     * 查看一条数据 / 修改页面
     * @param pid 主键ID
     * @param type 状态 为view 查看页面，update为修改页面 ,
     * @return
     * */
    @ApiOperation("查看一条数据")
    @GetMapping("/provider/{pid}")
    public String provider(@PathVariable("pid") Integer pid, @RequestParam(value = "type",defaultValue = "view") String type,Map<String,Object> map){
        Provider p = providerService.provider(pid);
        map.put("provider",p);
        return "provider/" + type;
    }

    /**
     * 修改操作
     * @param provider
     * @return
     */
    @PutMapping("/provider")
    public String update(Provider provider){
        providerService.save(provider);
        //重定向
        return "redirect:/providers";
    }

    /**
     * 前往添加页面
     * @return
     */
    @GetMapping("/provider")
    public String addProvider(){
        return "provider/add";
    }


    /**
     * 创建操作
     * @param provider
     * @return
     */
    @PostMapping("/provider")
    public String add(Provider provider) {
        if(provider.getProviderName()!=null){
            providerService.add(provider);
        }
        return "redirect:/providers";
    }

    /**
     * 删除操作
     * @param
     * @return
     */
    @DeleteMapping("/provider/{pid}")
    public String delete(@PathVariable("pid") Integer pid) {
        if(pid>0){
            providerService.delete(pid);
        }
        return "redirect:/providers";
    }

}
