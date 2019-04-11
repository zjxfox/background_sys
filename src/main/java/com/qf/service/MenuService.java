package com.qf.service;

import com.qf.dto.MenuInfoDto;

import java.util.List;

/**
 * Created by DELL on 2019/4/1.
 */
public interface MenuService {
    public List<MenuInfoDto> getAllMenu(int roleId);
}
