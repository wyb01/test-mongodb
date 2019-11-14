package com.java.service.impl;

import com.java.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * description：
 * author：丁鹏
 * date：09:49
 */
@CacheConfig(cacheNames = {"IndexServiceImpl_"})
@Service
public class IndexServiceImpl implements com.java.service.IndexService {
    @Autowired
    private IndexMapper indexMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Map<String,Object>> findWebMenus(String menuType){
        try {
            ValueOperations vps = redisTemplate.opsForValue();
            Object obj = vps.get("hxWebMenu");
            if(obj==null){
                List<Map<String, Object>> menuList = indexMapper.selectWebMenus(menuType);
                //将从mysql数据库中查询的数据重新存入到redis中去
                vps.set("hxWebMenu",menuList);
                //设置失效时间
                redisTemplate.expire("hxWebMenu",5, TimeUnit.MINUTES);
                return menuList;
            }
            return (List<Map<String,Object>>)obj;
        } catch (Exception e) {
            List<Map<String, Object>> menuList = indexMapper.selectWebMenus(menuType);
            System.err.println("IndexServiceImpl......findWebMenus....Redis忘记开启了");
            return menuList;
        }
    }

    @Cacheable(key="'findZXMenu'")
    @Override
    public List<Map<String,Object>> findZXMenu() {
        return indexMapper.selectWebMenus("1");
    }

    @CacheEvict(key="'findZXMenu'")
    @Override
    public void clearZxMenu() {
        System.out.println("在redis中的纵向导航栏数据已经被清空了");
    }

}
