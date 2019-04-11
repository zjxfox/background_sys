package com.qf.controller;

import com.qf.service.MenuService;
import com.qf.vo.AssignPermessionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by DELL on 2019/4/1.
 */
//声明这个control是一个restful风格的control
//等同于@ResponseBody+@Controller
@RestController
public class MenuInfoController {

    @Autowired
    MenuService menuService;

    @RequestMapping("getAllMenu")
    public Object getAllMenu(@RequestParam int roleId){
        return menuService.getAllMenu(roleId);
    }

    @RequestMapping("assignPermissionController")
    public Object assignPermission(@RequestBody AssignPermessionVo vo){
        System.out.println(vo);
        return null;
    }
}
