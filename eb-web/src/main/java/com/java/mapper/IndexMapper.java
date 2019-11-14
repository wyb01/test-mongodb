package com.java.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * description：
 * author：丁鹏
 * date：09:46
 */
public interface IndexMapper {

    /**
     * 查询横向或者纵向导航栏
     * @param menuType
     * @return
     */
    @Select("SELECT * FROM web_menu WHERE menuType=#{arg0} ORDER BY updateTime ASC LIMIT 8")
    List<Map<String,Object>> selectWebMenus(String menuType);

}
