package com.qf.service.impl;

import com.qf.dto.RoleInfoDto;
import com.qf.mapper.RoleInfoMapper;
import com.qf.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 2019/4/1.
 */
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleInfoMapper roleInfoMapper;

    public List<RoleInfoDto> getRoleByUserId(int userId) {
        return roleInfoMapper.getRoleByUserId(userId);
    }
}
