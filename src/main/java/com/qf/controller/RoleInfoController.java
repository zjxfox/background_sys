package com.qf.controller;

import com.qf.dto.RoleInfoDto;
import com.qf.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by DELL on 2019/4/1.
 */
@RestController
public class RoleInfoController {

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "getRoleByUserId",method = RequestMethod.POST)
    public List<RoleInfoDto> getRoleByUserId(@RequestParam int userId){
        return this.roleService.getRoleByUserId(userId);
    }
}
