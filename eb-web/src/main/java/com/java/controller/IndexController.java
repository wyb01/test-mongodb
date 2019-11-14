package com.java.controller;

import com.java.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * description：
 * author：丁鹏
 * date：09:30
 */
@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    /**
     * 获取横向导航栏
     * @return
     */
    @RequestMapping("/getHxWebMenu.do")
    public @ResponseBody List<Map<String,Object>> getHxWebMenu(){
        return indexService.findWebMenus("1");
    }

    //通过注解式来开发redis
    @RequestMapping("/getZXByRedisZJ.do")
    public @ResponseBody List<Map<String,Object>> getZXByRedisZJ(){
        return indexService.findZXMenu();
    }

    //通过注解式来开发redis
    @RequestMapping("/clear.do")
    public void clear(){
        indexService.clearZxMenu();
    }

}
