package com.java.service;

import java.util.List;
import java.util.Map;

/**
 * description：
 * author：丁鹏
 * date：08:49
 */
public interface WebMenuService {
    Map<String,Object> findWebMenu(Integer startIndex, Integer pageSize);

    boolean saveWebMenu(Map<String,Object> paramMap);

    boolean updateWebMenu(Map<String,Object> paramMap);

    boolean batchDelWebMenu(Map<String,Object> paramMap);
}
