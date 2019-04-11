package com.qf.mapper;

import com.qf.dto.MenuInfoDto;

import java.util.List;

/**
 * Created by DELL on 2019/4/1.
 */
public interface MenuInfoMapper {
    public List<MenuInfoDto> getAllMenu(int roleId);
}
