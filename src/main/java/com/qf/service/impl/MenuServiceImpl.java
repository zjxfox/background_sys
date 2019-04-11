package com.qf.service.impl;

import com.qf.dto.MenuInfoDto;
import com.qf.mapper.MenuInfoMapper;
import com.qf.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 2019/4/1.
 */
@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    MenuInfoMapper menuInfoMapper;

    public List<MenuInfoDto> getAllMenu(int roleId) {
        return menuInfoMapper.getAllMenu(roleId);
    }
}
